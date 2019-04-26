package annotate4j.classfile.structure.operation;

import annotate4j.core.bin.annotation.FieldOrder;

/**
 * @author Eugene Savin
 * @version Aug 23, 2010
 */
public class SipushOperation extends Operation {

    public SipushOperation() {
        OperationList.setCodePosition(OperationList.getCodePosition() + 3);
    }

    @FieldOrder(index = 2)
    private short s;

    public String getMnemonic() {
        return "sipush";
    }

    public short getS() {
        return s;
    }

    public void setS(short s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return super.toString() + " " + s;
    }
}
