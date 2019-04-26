package annotate4j.classfile.structure.stackmapframe;

import annotate4j.classfile.structure.stackmapframe.vti.VerificationTypeInfo;
import annotate4j.core.bin.annotation.FieldOrder;

/**
 * @author Eugene Savin
 */
public class SameLocals1StackItem extends StackMapFrame {

    @FieldOrder(index = 2)
    private VerificationTypeInfo stackItem;

    public short getOffsetDelta() {
        return (short) (getFrameType() - 64);
    }

    public VerificationTypeInfo getStackItem() {
        return stackItem;
    }

    public void setStackItem(VerificationTypeInfo stackItem) {
        this.stackItem = stackItem;
    }
}
