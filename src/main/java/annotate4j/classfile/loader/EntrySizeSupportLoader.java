package annotate4j.classfile.loader;


import annotate4j.core.bin.exceptions.*;
import annotate4j.core.bin.utils.*;
import annotate4j.classfile.structure.ClassFile;
import annotate4j.classfile.structure.annotation.EntrySize;
import annotate4j.core.bin.annotation.ContainerSize;
import annotate4j.core.bin.loader.InputStreamLoader;

import java.io.InputStream;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Eugene Savin
 */
public class EntrySizeSupportLoader extends InputStreamLoader {

    public EntrySizeSupportLoader(InputStream in) {
        super(in, new ClassFile());
    }

    protected boolean readList(Field f) throws
            IllegalAccessException, InvocationTargetException,
            FieldReadException {

        Type t = f.getGenericType();

        Class clazz = (Class) ((ParameterizedType) t).getActualTypeArguments()[0];
        long containerSize = getContainerSize(f);
        List list = null;
        try {
            Method getter = ReflectionHelper.getGetter(instance.getClass(), f.getName());
            Object obj = getter.invoke(instance);
            if (obj instanceof List){
                list = (List) obj;
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        if (list == null) {
            list = new ArrayList();
        }
        long l = 0;
        int dec = 0;
        while (l < containerSize) {
            Object o = readContainerEntry(clazz, f);
            if (o == null) {
                l++;
                dec++;
                continue;
            }
            EntrySize es = AnnotationHelper.getClassAnnotationOrNull(o.getClass().getName(), EntrySize.class);
            if (es != null && es.value() >= es.index()) {
                for (int i = 1; i <= es.value(); i++) {
                    if (i != es.index()) {
                        list.add(null);
                        l++;
                    } else {
                        list.add(o);
                    }
                }
            } else {
                list.add(o);
            }
            l++;
        }
        if (dec > 0) {
            decreaseContainerSize(f, dec);
        }

        try {
            Method m = ReflectionHelper.getSetter(instance.getClass(), f.getName(), List.class);
            m.invoke(instance, list);
        } catch (NoSuchMethodException e) {
            throw new FieldReadException("Can not receive setter for " + instance.getClass().getName() +
                    " class, field " + f.getName());
        }
        return true;

    }

    private void decreaseContainerSize(Field f, int dec) throws
            IllegalAccessException, InvocationTargetException,
            FieldReadException {

        ContainerSize cs;
        try {
            cs = AnnotationHelper.getAnnotation(instance.getClass(), f, ContainerSize.class);
        } catch (AnnotationNotSpecifiedException ee) {
            throw new UnspecifiedContainerSizeException(f.getName(), instance.getClass().getName());
        }
        long size = 0;
        if (cs.value() != -1) {
            size = cs.value();
        } else {

            long corrector = cs.corrector();
            String counterFieldName = cs.fieldName();

            Method getter;
            try {
                getter = ReflectionHelper.getGetter(instance.getClass(), counterFieldName);
            } catch (NoSuchMethodException e) {
                throw new WrongContainerSizeFieldException(f.getName(), counterFieldName);
            }
            Object o = getter.invoke(instance);
            if (o instanceof Number) {
                Number n = (Number) o;
                long l = n.longValue() + corrector;

                if (l < 0 && l > -256) {
                    size = (byte) l;
                } else {
                    size = n.longValue() + corrector;
                }

            }
        }
        Method setter;
        try {
            setter = ReflectionHelper.getSetter(instance.getClass(), cs.fieldName(), short.class);
        } catch (NoSuchMethodException e) {
            throw new WrongContainerSizeFieldException(f.getName(), cs.fieldName());
        }

        setter.invoke(instance, (short) (size - dec));
    }

}
