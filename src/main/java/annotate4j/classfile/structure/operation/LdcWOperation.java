package annotate4j.classfile.structure.operation;

import annotate4j.core.annotation.FieldOrder;

/**
 * @author Eugene Savin
 * @version Aug 23, 2010
 */
public class LdcWOperation extends Operation {

    public LdcWOperation() {
        OperationList.setCodePosition(OperationList.getCodePosition() + 3);
    }

    @FieldOrder(index = 2)
    private short index;

    public String getMnemonic() {
        return "ldc";
    }

    public short getIndex() {
        return index;
    }

    public void setIndex(short index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return super.toString() + " " + index;
    }
}
