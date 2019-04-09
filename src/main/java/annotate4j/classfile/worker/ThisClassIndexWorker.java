package annotate4j.classfile.worker;

import annotate4j.classfile.structure.ClassFile;

/**
 * @author Eugene Savin
 */
public class ThisClassIndexWorker extends ClassIndexWorker{

    @Override
    public Short getClassIndex(ClassFile classFile) {
        return classFile.getThisClassIndex();
    }
}
