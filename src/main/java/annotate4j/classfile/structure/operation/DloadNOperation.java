package annotate4j.classfile.structure.operation;

/**
 * @author Eugene Savin
 * @version Aug 23, 2010
 */
public class DloadNOperation extends Operation {

    public String getMnemonic() {
        return "dload_" + (getOpcode() - 38);
    }

}
