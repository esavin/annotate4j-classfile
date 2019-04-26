package annotate4j.classfile.structure.operation;

import annotate4j.core.bin.annotation.FieldOrder;

/**
 * @author Eugene Savin
 * @version Aug 24, 2010
 */
public class IfOperation extends Operation {

    public IfOperation() {
        OperationList.setCodePosition(OperationList.getCodePosition() + 3);

    }

    @FieldOrder(index=2)
    public short address;

    public String getMnemonic() {
        switch (0x0FF & (int)getOpcode()){
            case (153):
            return "ifeq";
            case (154):
                return "ifne";
            case (155):
                return "iflt";
            case (156):
                return "ifge";
            case (157):
                return "ifgt";
            case (158):
                return "ifle";
        }
        throw new RuntimeException("Wrong opcode for if operation: " + getOpcode());
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



