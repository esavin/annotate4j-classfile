package annotate4j.classfile.structure.operation;

/**
 * @author Eugene Savin
 * @version Aug 23, 2010
 */
public class LconstNOperation extends Operation {

    public String getMnemonic() {
        return "lconst_" + (getOpcode() - 9);
    }

}
