package annotate4j.classfile.structure.operation;

import annotate4j.core.annotation.FieldOrder;

/**
 * @author Eugene Savin
 * @version Aug 23, 2010
 */
public class FloadOperation extends Operation {

    public FloadOperation() {
        OperationList.setCodePosition(OperationList.getCodePosition() + 2);
    }

    @FieldOrder(index = 2)
    private byte index;

    public String getMnemonic() {
        return "fload";
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
