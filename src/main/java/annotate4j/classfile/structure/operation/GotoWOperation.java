package annotate4j.classfile.structure.operation;

import annotate4j.core.bin.annotation.FieldOrder;

/**
 * @author Eugene Savin
 * @version Aug 26, 2010
 */
public class GotoWOperation extends Operation {

    public GotoWOperation() {
        OperationList.setCodePosition(OperationList.getCodePosition() + 5);
    }

    @FieldOrder(index = 2)
    private int branchoffset;

    public String getMnemonic() {
        return "goto_w";
    }

    public int getBranchoffset() {
        return branchoffset;
    }

    public void setBranchoffset(int branchoffset) {
        this.branchoffset = branchoffset;
    }

    @Override
    public String toString() {
        return super.toString() + " " + branchoffset;    
    }
}
