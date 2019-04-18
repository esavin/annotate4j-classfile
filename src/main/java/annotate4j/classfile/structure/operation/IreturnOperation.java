package annotate4j.classfile.structure.operation;

/**
 * @author Eugene Savin
 * @version Aug 26, 2010
 */
public class IreturnOperation extends Operation {

    public IreturnOperation() {
        OperationList.setCodePosition(OperationList.getCodePosition() + 1);
    }

    public String getMnemonic() {
        return "ireturn";
    }

}
