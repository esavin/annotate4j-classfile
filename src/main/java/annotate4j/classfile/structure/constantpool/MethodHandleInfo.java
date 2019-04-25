package annotate4j.classfile.structure.constantpool;

import annotate4j.core.annotation.FieldOrder;

/**
 * The CONSTANT_MethodHandle_info structure is used to represent a method handle:
 * CONSTANT_MethodHandle_info {
 * u1 tag;
 * u1 reference_kind;
 * u2 reference_index;
 * }
 */
public class MethodHandleInfo extends ConstantPoolItem {

    /**
     * The value of the reference_kind item must be in the range 1 to 9. The
     * value denotes the kind of this method handle, which characterizes its bytecode
     * behavior (§5.4.3.5).
     */

    @FieldOrder(index = 2)
    private byte referenceKind;

    /**
     * The value of the reference_index item must be a valid index into the
     * constant_pool table.
     */
    @FieldOrder(index = 3)
    private short referenceIndex;

    public byte getReferenceKind() {
        return referenceKind;
    }

    public void setReferenceKind(byte referenceKind) {
        this.referenceKind = referenceKind;
    }

    public short getReferenceIndex() {
        return referenceIndex;
    }

    public void setReferenceIndex(short referenceIndex) {
        this.referenceIndex = referenceIndex;
    }
}
