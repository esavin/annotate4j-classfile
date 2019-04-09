package annotate4j.classfile.worker;

import annotate4j.classfile.structure.ClassFile;
import annotate4j.classfile.structure.annotation.Annotation;
import annotate4j.classfile.structure.attribute.Attribute;
import annotate4j.classfile.structure.attribute.RuntimeVisibleAnnotationsAttribute;
import annotate4j.classfile.structure.attribute.SourceFileAttribute;
import annotate4j.classfile.structure.constantpool.Utf8Info;
import annotate4j.core.worker.Worker;

import java.util.List;

/**
 * @author Eugene Savin
 */
public class PrintAspectClassFileWorker implements Worker<ClassFile, Void> {
    @Override
    public Void doWork(ClassFile classFile) {
        List<Attribute> attributeList = classFile.getAttributeList();
        for (Attribute atr : attributeList) {
            if (atr instanceof RuntimeVisibleAnnotationsAttribute) {
                RuntimeVisibleAnnotationsAttribute a = (RuntimeVisibleAnnotationsAttribute) atr;
                List<Annotation> annotations = a.getAnnotationList();
                for (Annotation an : annotations) {
                    Object obj = classFile.getConstantPoolList().get(an.getTypeIndex() - 1);
                    if (obj instanceof Utf8Info) {
                        Utf8Info u = (Utf8Info) obj;
                        if (u.getBytesStr().equals("Lorg/aspectj/lang/annotation/Aspect;")) {
                            printSourceFileName(classFile);
                        }
                    }
                }
            }
        }
        return null;
    }

    private void printSourceFileName(ClassFile classFile) {
        List<Attribute> attributeList = classFile.getAttributeList();
        for (Attribute atr : attributeList) {
            if (atr instanceof SourceFileAttribute) {
                SourceFileAttribute sfa = (SourceFileAttribute) atr;
                Object obj = classFile.getConstantPoolList().get(sfa.getSourceFileIndex() - 1);
                if (obj instanceof Utf8Info) {
                    Utf8Info u = (Utf8Info) obj;
                    System.out.println(u.getBytesStr());

                }
            }
        }
    }
}
