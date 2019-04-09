package annotate4j.classfile.worker;

import annotate4j.classfile.structure.ClassFile;

/**
 * @author Eugene Savin
 */
public class SuperClassIndexWorker extends ClassIndexWorker{

    @Override
    public Short getClassIndex(ClassFile classFile) {
        return classFile.getSuperClassIndex();
    }
}
