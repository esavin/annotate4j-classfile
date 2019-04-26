package annotate4j.classfile.structure.operation;

import annotate4j.core.bin.annotation.FieldOrder;

/**
 * @author Eugene Savin
 * @version Aug 26, 2010
 */
public class NewarrayOperation extends Operation {

    public NewarrayOperation() {
        OperationList.setCodePosition(OperationList.getCodePosition() + 2);
    }

    @FieldOrder(index = 2)
    public byte atype;

    public String getMnemonic() {
        return "newarray";
    }

    public byte getAtype() {
        return atype;
    }

    public void setAtype(byte atype) {
        this.atype = atype;
    }

    public String getArrayType() {

        switch (atype) {
            case (4):
                return "T_BOOLEAN";
            case (5):
                return "T_CHAR";
            case (6):
                return "T_FLOAT";
            case (7):
                return "T_DOUBLE";
            case (8):
                return "T_BYTE";
            case (9):
                return "T_SHORT";
            case (10):
                return "T_INT";
            case (11):
                return "T_LONG";
            default:
                throw new RuntimeException("wrong array type or not initialized: " + atype);
        }
    }

    @Override
    public String toString() {
        return super.toString() + " " + getArrayType();    
    }
}
