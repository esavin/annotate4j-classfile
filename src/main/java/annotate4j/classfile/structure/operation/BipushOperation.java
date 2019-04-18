package annotate4j.classfile.structure.operation;

import annotate4j.core.annotation.FieldOrder;

/**
 * @author Eugene Savin
 * @version Aug 23, 2010
 */
public class BipushOperation extends Operation {

    public BipushOperation() {
        OperationList.setCodePosition(OperationList.getCodePosition() + 2);
    }

    @FieldOrder(index = 2)
    private byte b;

    public String getMnemonic() {
        return "bipush";
    }

    public byte getB() {
        return b;
    }

    public void setB(byte b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return super.toString() + " " + b;    
    }
}
