package annotate4j.classfile.structure.operation;

import annotate4j.core.annotation.FieldOrder;

/**
 * @author Eugene Savin
 * @version Aug 24, 2010
 */
public class IfAcmpOperation extends Operation {

    public IfAcmpOperation() {
        OperationList.setCodePosition(OperationList.getCodePosition() + 3);
    }

    @FieldOrder(index=2)
    public short address;

    public String getMnemonic() {
        switch (0x0FF & (int)getOpcode()){
            case (165):
            return "if_acmpeq";
            case (166):
                return "if_icmpne";
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



