package annotate4j.classfile.structure.operation;

/**
 * @author Eugene Savin
 * @version Aug 23, 2010
 */
public class AloadNOperation extends Operation {

    public String getMnemonic() {
        return "aload_" + (getOpcode() - 42);
    }

}
