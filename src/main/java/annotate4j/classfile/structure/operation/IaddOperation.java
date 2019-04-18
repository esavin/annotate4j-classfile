package annotate4j.classfile.structure.operation;

/**
 * @author Eugene Savin
 * @version Aug 23, 2010
 */
public class IaddOperation extends Operation {

    public IaddOperation() {
        OperationList.setCodePosition(OperationList.getCodePosition() + 1);
    }

    public String getMnemonic() {
        return "iadd";
    }

}
