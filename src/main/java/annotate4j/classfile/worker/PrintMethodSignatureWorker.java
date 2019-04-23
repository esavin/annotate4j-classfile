package annotate4j.classfile.worker;

import annotate4j.classfile.structure.ClassFile;
import annotate4j.classfile.structure.Method;
import annotate4j.core.worker.Worker;

import java.util.List;

/**
 * @author Eugene Savin
 */
public class PrintMethodSignatureWorker implements Worker<ClassFile, Void> {

    @Override
    public Void doWork(ClassFile classFile) {
        List<Method> methods = classFile.getMethodList();
        int i = 0;
        for (Method m : methods) {
            String methodStr = m.toString();
            System.out.println(i + ": " + methodStr);
            i++;
        }
        return null;
    }

}
