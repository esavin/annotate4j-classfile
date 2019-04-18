package annotate4j.classfile.structure.operation;

/**
 * @author Eugene Savin
 * @version Aug 23, 2010
 */
public class DupX1Operation extends Operation {

    public DupX1Operation() {
        OperationList.setCodePosition(OperationList.getCodePosition() + 1);
    }

    public String getMnemonic() {
        return "dup_x1";
    }

}
