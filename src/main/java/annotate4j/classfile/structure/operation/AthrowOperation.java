package annotate4j.classfile.structure.operation;

/**
 * @author Eugene Savin
 * @version Aug 26, 2010
 */
public class AthrowOperation extends Operation {

    public AthrowOperation() {
        OperationList.setCodePosition(OperationList.getCodePosition() + 1);
    }

    public String getMnemonic() {
        return "athrow";
    }

}
