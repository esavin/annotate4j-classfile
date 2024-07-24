package annotate4j.classfile.structure.annotation.target;

import annotate4j.core.bin.annotation.FieldOrder;

public class ThrowsTarget extends TargetTypeAndInfo {

    @FieldOrder(index = 2)
    private short throwsTypeIndex;

    public short getThrowsTypeIndex() {
        return throwsTypeIndex;
    }

    public void setThrowsTypeIndex(short throwsTypeIndex) {
        this.throwsTypeIndex = throwsTypeIndex;
    }
}
