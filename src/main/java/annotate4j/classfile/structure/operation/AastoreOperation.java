package annotate4j.classfile.structure.operation;

/**
 * @author Eugene Savin
 * @version Aug 23, 2010
 */
public class AastoreOperation extends Operation {

    public AastoreOperation() {
        OperationList.setCodePosition(OperationList.getCodePosition() + 1);
    }

    public String getMnemonic() {
        return "aastore";
    }

}
