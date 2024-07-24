package annotate4j.classfile.structure.annotation.target;

import annotate4j.core.bin.annotation.FieldOrder;

public class TypeArgumentTarget extends TargetTypeAndInfo {

    @FieldOrder(index = 2)
    private short offset;

    @FieldOrder(index = 3)
    private short typeArgumentIndex;

    public short getOffset() {
        return offset;
    }

    public void setOffset(short offset) {
        this.offset = offset;
    }

    public short getTypeArgumentIndex() {
        return typeArgumentIndex;
    }

    public void setTypeArgumentIndex(short typeArgumentIndex) {
        this.typeArgumentIndex = typeArgumentIndex;
    }
}
