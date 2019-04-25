package annotate4j.classfile.worker;

import annotate4j.classfile.structure.ClassFile;
import annotate4j.classfile.structure.constantpool.ClassInfo;
import annotate4j.classfile.structure.constantpool.ConstantPoolItem;
import annotate4j.classfile.structure.constantpool.Utf8Info;
import annotate4j.core.worker.IdentityMapWorker;

import java.util.IdentityHashMap;
import java.util.List;

/**
 * @author Eugene Savin
 */
public class InterfaceIndexWorker implements IdentityMapWorker<ClassFile> {

    @Override
    public IdentityHashMap<Object, String> doWork(ClassFile classFile) {
        IdentityHashMap<Object, String> m = new IdentityHashMap<Object, String>();
        StringBuffer interfaces = new StringBuffer();

        for (Short sh : classFile.getInterfaceIndexList()) {
            List<ConstantPoolItem> cp = classFile.getConstantPoolList();
            ConstantPoolItem cpElement = cp.get(sh - 1);
            if (cpElement instanceof ClassInfo) {
                ClassInfo cInfo = (ClassInfo) cpElement;
                short nameIndex = cInfo.getNameIndex();
                cpElement = cp.get(nameIndex - 1);
                if (cpElement instanceof Utf8Info) {
                    Utf8Info u = (Utf8Info) cpElement;
                    String intrf = u.getBytesStr().replaceAll("/", ".");
                    interfaces.append(intrf).append(", ");
                    m.put(sh, intrf);
                }

            }
        }
        if (interfaces.length() > 2) {
            interfaces.setLength(interfaces.length() - 2);
        }
        m.put(classFile.getInterfaceIndexList(), interfaces.toString());

        return m;
    }
}
