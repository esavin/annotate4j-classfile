package annotate4j.classfile.structure.operation;

import annotate4j.core.bin.annotation.FieldOrder;

public class WideFormat2Operation extends WideOperation {

    @FieldOrder(index = 3)
    private short indexValue;

    @FieldOrder(index = 4)
    private short constValue;


    public short getIndexValue() {
        return indexValue;
    }

    public void setIndexValue(short indexValue) {
        this.indexValue = indexValue;
    }

    public short getConstValue() {
        return constValue;
    }

    public void setConstValue(short constValue) {
        this.constValue = constValue;
    }
}
