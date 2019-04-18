package annotate4j.classfile.structure.operation;

import annotate4j.classfile.structure.constantpool.CommonRefInfo;
import annotate4j.core.annotation.FieldOrder;

/**
 * @author Eugene Savin
 * @version Aug 26, 2010
 */
public class InvokeinterfaceOperation extends Operation {

    public InvokeinterfaceOperation() {
        OperationList.setCodePosition(OperationList.getCodePosition() + 5);
    }

    @FieldOrder(index = 2)
    private short index;

    @FieldOrder(index = 3)
    private byte count;

    @FieldOrder(index = 4)
    private byte zerro;


    public String getMnemonic() {
        return "invokeinterface";
    }

    public short getIndex() {
        return index;
    }

    public void setIndex(short index) {
        this.index = index;
    }

    public byte getCount() {
        return count;
    }

    public void setCount(byte count) {
        this.count = count;
    }

    public byte getZerro() {
        return zerro;
    }

    public void setZerro(byte zerro) {
        this.zerro = zerro;
    }

    /*@Override
    public String toString() {
        return super.toString() + " " + index + " " + count + " " + zerro;    
    }*/

    @Override
    public String toString() {
        CommonRefInfo commonInfo = (CommonRefInfo) getConstantPoolEntry(index);

        return super.toString() + " " + getClassName(commonInfo.getClassIndex())  + "   "
                + getCommonSignature(index);
    }
}
