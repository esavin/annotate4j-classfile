package annotate4j.classfile.worker;

import annotate4j.classfile.structure.ClassFile;
import annotate4j.classfile.structure.annotation.Annotation;
import annotate4j.classfile.structure.attribute.Attribute;
import annotate4j.classfile.structure.attribute.RuntimeVisibleAnnotationsAttribute;
import annotate4j.classfile.structure.constantpool.ConstantPoolItem;
import annotate4j.classfile.structure.constantpool.Utf8Info;
import annotate4j.core.worker.IdentityMapWorker;

import java.util.IdentityHashMap;
import java.util.List;

/**
 * @author Eugene Savin
 */
public class ClassRuntimeAnnotationWorker implements IdentityMapWorker<ClassFile> {
    @Override
    public IdentityHashMap<Object, String> doWork(ClassFile classFile) {
        IdentityHashMap<Object, String> m = new IdentityHashMap<Object, String>();
        List<ConstantPoolItem> cp = classFile.getConstantPoolList();
        List<Attribute> attrList = classFile.getAttributeList();
        for (Attribute attr : attrList) {
            if (attr instanceof RuntimeVisibleAnnotationsAttribute) {
                StringBuffer sb = new StringBuffer();
                RuntimeVisibleAnnotationsAttribute rva = (RuntimeVisibleAnnotationsAttribute) attr;
                List<Annotation> annotations = rva.getAnnotationList();
                for (Annotation a : annotations) {
                    String s = decodeAnnotation(cp, a);
                    sb.append(s).append("\n");
                    m.put(a, s);
                }
                if (sb.length() > "\n".length()) {
                    sb.setLength(sb.length() - "\n".length());
                    m.put(attr, sb.toString());
                    m.put(annotations, sb.toString());
                }
            }
        }
        return m;
    }

    private String decodeAnnotation(List<ConstantPoolItem> cp, Annotation a) {
        short index = a.getTypeIndex();
        ConstantPoolItem elem = cp.get(index - 1);
        if (elem instanceof Utf8Info){
            Utf8Info u = (Utf8Info) elem;
            String str = u.getBytesStr();
            if (str.startsWith("L")){
                str = str.replaceFirst("L", "@");
            }
            str = str.replaceAll("/", ".");
            if (str.endsWith(";")){
                str = str.substring(0, str.length() - 1);
            }
            return str;
        }
        return "";
    }
}
