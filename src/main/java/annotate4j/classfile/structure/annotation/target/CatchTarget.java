package annotate4j.classfile.structure.annotation.target;

import annotate4j.core.bin.annotation.FieldOrder;

public class CatchTarget extends TargetTypeAndInfo {

    @FieldOrder(index = 2)
    private short exceptionTableIndex;;

    public short getExceptionTableIndex() {
        return exceptionTableIndex;
    }

    public void setExceptionTableIndex(short exceptionTableIndex) {
        this.exceptionTableIndex = exceptionTableIndex;
    }
}
