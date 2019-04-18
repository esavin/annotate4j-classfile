package annotate4j.classfile.structure.operation;

/**
 * @author Eugene Savin
 * @version Aug 23, 2010
 */
public class DaloadOperation extends Operation {

    public DaloadOperation() {
        OperationList.setCodePosition(OperationList.getCodePosition() + 1);
    }

    public String getMnemonic() {
        return "daload";
    }

}
