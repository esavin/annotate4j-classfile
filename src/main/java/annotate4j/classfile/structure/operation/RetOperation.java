package annotate4j.classfile.structure.operation;

import annotate4j.core.bin.annotation.FieldOrder;

/**
 * @author Eugene Savin
 * @version Aug 26, 2010
 */
public class RetOperation extends Operation {

    public RetOperation() {
        OperationList.setCodePosition(OperationList.getCodePosition() + 2);
    }

    @FieldOrder(index = 2)
    private byte index;

    public String getMnemonic() {
        return "ret";
    }

    public byte getIndex() {
        return index;
    }

    public void setIndex(byte index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return super.toString() + " " + index;
    }
}
