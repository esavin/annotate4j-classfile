package annotate4j.classfile.structure.operation;

/**
 * @author Eugene Savin
 * @version Aug 26, 2010
 */
public class BreakpointOperation extends Operation {

    public BreakpointOperation() {
        OperationList.setCodePosition(OperationList.getCodePosition() + 1);
    }

    public String getMnemonic() {
        return "breakpoint";
    }

}
