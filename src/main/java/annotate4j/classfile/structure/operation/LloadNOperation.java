package annotate4j.classfile.structure.operation;

/**
 * @author Eugene Savin
 * @version Aug 23, 2010
 */
public class LloadNOperation extends Operation {

    public LloadNOperation() {
        OperationList.setCodePosition(OperationList.getCodePosition() + 1);
    }

    public String getMnemonic() {
        return "lload_" + (getOpcode() - 30);
    }

}
