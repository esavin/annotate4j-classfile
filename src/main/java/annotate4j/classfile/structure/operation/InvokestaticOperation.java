package annotate4j.classfile.structure.operation;

import annotate4j.classfile.structure.constantpool.CommonRefInfo;
import annotate4j.core.bin.annotation.FieldOrder;

/**
 * @author Eugene Savin
 * @version Aug 26, 2010
 */
public class InvokestaticOperation extends Operation {

    public InvokestaticOperation() {
        OperationList.setCodePosition(OperationList.getCodePosition() + 3);
    }

    @FieldOrder(index = 2)
    private short index;

    public String getMnemonic() {
        return "invokestatic";
    }

    public short getIndex() {
        return index;
    }

    public void setIndex(short index) {
        this.index = index;
    }

    @Override
    public String toString() {
        CommonRefInfo commonInfo = (CommonRefInfo) getConstantPoolEntry(index);

        return super.toString() + " " + getClassName(commonInfo.getClassIndex())  + "   "
                + getCommonSignature(index);
    }
}
