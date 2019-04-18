package annotate4j.classfile.structure.operation;

import annotate4j.core.annotation.FieldOrder;

/**
 * @author Eugene Savin
 * @version Aug 24, 2010
 */
public class IfIcmpOperation extends Operation {

    public IfIcmpOperation() {
        OperationList.setCodePosition(OperationList.getCodePosition() + 3);
    }

    @FieldOrder(index=2)
    public short address;

    public String getMnemonic() {
        switch (0x0FF & (int)getOpcode()){
            case (159):
            return "if_icmpeq";
            case (160):
                return "if_icmpne";
            case (161):
                return "if_icmplt";
            case (162):
                return "if_icmpge";
            case (163):
                return "if_icmpgt";
            case (164):
                return "if_icmple";
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



