package annotate4j.classfile.loader;


import annotate4j.core.bin.exceptions.*;
import annotate4j.core.bin.utils.*;
import annotate4j.classfile.structure.ClassFile;
import annotate4j.classfile.structure.annotation.EntrySize;
import annotate4j.classfile.structure.attribute.Attribute;
import annotate4j.core.bin.annotation.ContainerSize;
import annotate4j.core.bin.annotation.Inject;
import annotate4j.core.bin.loader.InputStreamLoader;
import annotate4j.core.bin.loader.GenericLoader;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Eugene Savin
 */
public class EntrySizeSupportLoader extends InputStreamLoader {

    private static Logger log = Logger.getLogger(EntrySizeSupportLoader.class.getName());

    public EntrySizeSupportLoader(InputStream in) {
        super(in, new ClassFile());
    }

    @Override
    public Object load() throws FieldReadException {
        level++;
        if (log.isLoggable(Level.FINE)) {
            StringBuffer sb = new StringBuffer();
            for (int k = 0; k < level; k++) {
                sb.append("    ");
            }

            sb.append("load ").append(instance.getClass().getName()).
                    append(" class, parent class: ").append(parent.getClass().getName());
            log.fine(sb.toString());
            if (instance.getClass().getName().equals(offsetClassName)) {
                log.fine("there are " + offset + " bytes before " + offsetClassName);
            }

        }
        Field[] fields = FieldsBuilder.buildFields(instance, parent);

        for (int i = 0; i < fields.length; i++) {
            Field f = fields[i];
            if (log.isLoggable(Level.FINE)) {
                if (f.getName().equals(offsetFieldName)) {
                    log.fine("there are : " + offset + " bytes before " + offsetFieldName);
                }
            }
            Inject inject = AnnotationHelper.getAnnotationOrNull(instance.getClass(), f, Inject.class);
            if (inject != null) {
                try {
                    Object obj = null;
                    if (injectedVariable != null) {
                        obj = injectedVariable.get(inject.fieldName());
                    }
                    if (obj == null) {
                        Method m = ReflectionHelper.getGetter(instance.getClass(), inject.fieldName());
                        obj = m.invoke(instance);
                    }
                    if (obj == null) {
                        throw new FieldReadException("Can not receive field " + inject.fieldName() + " into class " + instance.getClass());
                    }
                    if (injectedVariable == null) {
                        injectedVariable = new HashMap<String, Object>();
                    }
                    injectedVariable.put(inject.fieldName(), obj);
                    isNeedInjection = true;
                } catch (NoSuchMethodException e) {
                    throw new FieldReadException("Can not found getter for field " + inject.fieldName() + " in class " + instance.getClass().getName());
                } catch (IllegalAccessException e1) {
                    throw new FieldReadException("Can not invoke getter for field " + inject.fieldName() + " in class " + instance.getClass().getName());
                } catch (IllegalArgumentException e2) {
                    throw new FieldReadException("Can not invoke getter for field " + inject.fieldName() + " in class " + instance.getClass().getName());
                } catch (InvocationTargetException e3) {
                    throw new FieldReadException("Can not invoke getter for field " + inject.fieldName() + " in class " + instance.getClass().getName());
                }
            } else {
                isNeedInjection = false;
            }
            readField(f);

            if (log.isLoggable(Level.FINE)) {
                Object value = new String();
                try {
                    Method m = ReflectionHelper.getGetter(instance.getClass(), f);
                    value = m.invoke(instance);
                } catch (Exception e) {
                    //
                }


                StringBuffer sb = new StringBuffer();
                for (int k = 0; k < level; k++) {
                    sb.append("    ");
                }
                sb.append("  ").append(f.getType().getName()).append(" ").append(f.getName()).
                        append(" = `").append(value).append("`");
                log.fine(sb.toString());

            }
        }

        if (cs == null) {
            throw new FieldReadException("Can not switch structure: classSwitcher not defined (null)");
        }

        Object inheritor;
        try {
            try {
                inheritor = cs.switchClass(instance, injectedVariable);
            } catch (ResolvedClassNotFoundException cnfe) {
                log.warning(cnfe.getMessage());
                if (instance instanceof Attribute) {
                    Attribute attribute = (Attribute) instance;
                    try {
                        offset += attribute.getAttributeLength();
                        in.skipBytes(attribute.getAttributeLength());
                    } catch (IOException ioe) {
                        throw new FieldReadException("Can not read byte ", ioe);
                    }
                    level--;
                    return null;
                } else {
                    throw cnfe;
                }
            }

        } catch (ResolveException e) {
            throw new FieldReadException(e);
        }

        if (inheritor != instance) {
            GenericLoader loader;
            try {
                if (injectedVariable != null) {
                    isNeedInjection = true;
                }
                loader = (GenericLoader) this.clone();
            } catch (CloneNotSupportedException e) {
                throw new FieldReadException("Can not call clone() method");
            }
            CastHelper castHelper = new CastHelperImpl();
            castHelper.cast(instance, inheritor);
            inheritor = loader.load(inheritor, instance);
            offset = loader.getOffset();
            level--;
            return inheritor;
        }
        level--;
        return instance;
    }

    protected boolean readList(Field f) throws
            IllegalAccessException, InvocationTargetException,
            FieldReadException {

        Type t = f.getGenericType();

        Class clazz = (Class) ((ParameterizedType) t).getActualTypeArguments()[0];
        long containerSize = getContainerSize(f);
        List list = new ArrayList();
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
