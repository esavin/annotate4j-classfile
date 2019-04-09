package annotate4j.classfile.worker;

import annotate4j.classfile.structure.ClassFile;
import annotate4j.core.worker.IdentityMapWorker;

import java.util.IdentityHashMap;

/**
 * @author Eugene Savin
 */
public class ClassAccessFlagWorker implements IdentityMapWorker<ClassFile> {
    @Override
    public IdentityHashMap<Object, String> doWork(ClassFile classFile) {
        IdentityHashMap<Object, String> m = new IdentityHashMap<Object, String>();
        Short flag = classFile.getAccessFlag();
        StringBuffer sb = new StringBuffer();
        boolean isInterface = false;
        if ((flag | 0x1) == flag) {
            sb.append("public ");
        }
        if ((flag | 0x10) == flag) {
            sb.append("final ");
        }
        if ((flag | 0x200) == flag) {
            isInterface = true;
        }
        if (((flag | 0x400) == flag) && !isInterface ) {
            sb.append("abstract ");
        }                                               
        if (isInterface){
            sb.append("interface");
        } else {
            sb.append("class");
        }
        m.put(flag, sb.toString());
        return m;
    }
}
