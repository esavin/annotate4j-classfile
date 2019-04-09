package annotate4j.classfile.worker;

import annotate4j.classfile.structure.constantpool.Utf8Info;
import annotate4j.core.worker.ToStringWorker;

/**
 * @author Eugene Savin
 * @version Nov 1, 2010
 */
public class Utf8ToStringWorker implements ToStringWorker<Utf8Info> {

    @Override
    public String doWork(Utf8Info utf8Info) {
        byte b[] = utf8Info.getBytes();
        return new String(b);
    }
}
