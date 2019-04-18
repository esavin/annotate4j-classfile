package annotate4j.classfile.structure.operation;

import annotate4j.core.annotation.FieldOrder;

/**
 * @author Eugene Savin
 * @version Aug 26, 2010
 */
public class JsrOperation extends Operation {

    public JsrOperation() {
        OperationList.setCodePosition(OperationList.getCodePosition() + 3);
    }

    @FieldOrder(index = 2)
    private short address;

    public String getMnemonic() {
        return "jsr";
    }

    public short getAddress() {
        return address;
    }

    public void setAddress(short address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return super.toString() + " " + address;
    }
}
