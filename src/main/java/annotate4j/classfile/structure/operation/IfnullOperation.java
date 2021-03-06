package annotate4j.classfile.structure.operation;

import annotate4j.core.bin.annotation.FieldOrder;

/**
 * @author Eugene Savin
 * @version Aug 26, 2010
 */
public class IfnullOperation extends Operation {

    public IfnullOperation() {
        OperationList.setCodePosition(OperationList.getCodePosition() + 3);
    }

    @FieldOrder(index = 2)
    private short index;

    public String getMnemonic() {
        return "ifnull";
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
