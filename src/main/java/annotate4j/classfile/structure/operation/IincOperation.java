package annotate4j.classfile.structure.operation;

import annotate4j.core.annotation.FieldOrder;

/**
 * @author Eugene Savin
 * @version Aug 23, 2010
 */
public class IincOperation extends Operation {

    public IincOperation() {
        OperationList.setCodePosition(OperationList.getCodePosition() + 3);
    }

    @FieldOrder(index = 2)
    private byte index;

    @FieldOrder(index = 3)
    private byte constant;

    public String getMnemonic() {
        return "iinc";
    }

    public byte getConstant() {
        return constant;
    }

    public void setConstant(byte constant) {
        this.constant = constant;
    }

    public byte getIndex() {
        return index;
    }

    public void setIndex(byte index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return super.toString() + " " + index + " " + constant;    
    }
}
