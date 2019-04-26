package annotate4j.classfile.structure.stackmapframe.vti;

import annotate4j.core.bin.annotation.FieldOrder;

/**
 * @author Eugene Savin
 */
public class ItemUninitialized extends VerificationTypeInfo {

    @FieldOrder(index = 2)
    private short offset;

    public short getOffset() {
        return offset;
    }

    public void setOffset(short offset) {
        this.offset = offset;
    }
}
