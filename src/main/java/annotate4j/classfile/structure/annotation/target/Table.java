package annotate4j.classfile.structure.annotation.target;

import annotate4j.core.bin.annotation.FieldOrder;

public class Table {

    @FieldOrder(index = 1)
    private short startPc;

    @FieldOrder(index = 2)
    private short length;

    @FieldOrder(index = 3)
    private short index;

    public short getStartPc() {
        return startPc;
    }

    public void setStartPc(short startPc) {
        this.startPc = startPc;
    }

    public short getLength() {
        return length;
    }

    public void setLength(short length) {
        this.length = length;
    }

    public short getIndex() {
        return index;
    }

    public void setIndex(short index) {
        this.index = index;
    }
}
