package annotate4j.classfile.worker;

import annotate4j.classfile.structure.ClassFile;
import annotate4j.classfile.structure.constantpool.ConstantPoolItem;
import annotate4j.classfile.structure.constantpool.Utf8Info;
import annotate4j.core.worker.Worker;

import java.util.List;

/**
 * @author Eugene Savin
 */
public class FindStringWorker implements Worker<ClassFile, Void> {

    @Override
    public Void doWork(ClassFile classFile) {
        List<ConstantPoolItem> constantPoolItem = classFile.getConstantPoolList();
        int index = 0;
        for (ConstantPoolItem cp : constantPoolItem) {
            if (cp instanceof Utf8Info) {
                Utf8Info u = (Utf8Info) cp;
                String str = u.getBytesStr();
                if (str.contains("is invalid")) {
                    System.out.println(index);
                }

            }
            index++;
        }
        return null;
    }

}
