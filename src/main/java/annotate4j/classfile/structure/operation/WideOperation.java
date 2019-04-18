package annotate4j.classfile.structure.operation;

import annotate4j.core.annotation.FieldOrder;

/**
 * @author Eugene Savin
 * @version Aug 26, 2010
 */



public class WideOperation extends Operation {

    public WideOperation() {
        // TODO increment opcode counter

        throw new RuntimeException("Not implemented");
    }

    @FieldOrder(index = 2)
    private byte innerOpcode;

    public String getMnemonic() {
        return "wide";
    }

    public byte getInnerOpcode() {
        return innerOpcode;
    }

    public void setInnerOpcode(byte innerOpcode) {
        this.innerOpcode = innerOpcode;
    }
}
