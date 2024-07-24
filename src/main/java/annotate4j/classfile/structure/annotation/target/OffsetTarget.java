package annotate4j.classfile.structure.annotation.target;

import annotate4j.core.bin.annotation.FieldOrder;

public class OffsetTarget extends TargetTypeAndInfo {

    @FieldOrder(index = 2)
    private short offset;

    public short getOffset() {
        return offset;
    }

    public void setOffset(short offset) {
        this.offset = offset;
    }
}
