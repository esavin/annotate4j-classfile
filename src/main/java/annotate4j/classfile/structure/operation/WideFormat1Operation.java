package annotate4j.classfile.structure.operation;

import annotate4j.core.bin.annotation.FieldOrder;

public class WideFormat1Operation extends WideOperation {

    @FieldOrder(index = 3)
    private short indexValue;

    public short getIndexValue() {
        return indexValue;
    }

    public void setIndexValue(short indexValue) {
        this.indexValue = indexValue;
    }
}
