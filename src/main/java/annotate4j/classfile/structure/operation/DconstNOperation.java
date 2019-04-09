package annotate4j.classfile.structure.operation;

/**
 * @author Eugene Savin
 * @version Aug 23, 2010
 */
public class DconstNOperation extends Operation {

    public String getMnemonic() {
        return "dconst_" + (getOpcode() - 14);
    }

}
