package annotate4j.classfile.structure.operation;

/**
 * @author Eugene Savin
 * @version Aug 23, 2010
 */
public class FconstNOperation extends Operation {

    public String getMnemonic() {
        return "fconst_" + (getOpcode() - 11);
    }

}
