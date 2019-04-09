package annotate4j.classfile.structure.stackmapframe;

import annotate4j.classfile.structure.stackmapframe.vti.VerificationTypeInfo;
import annotate4j.core.annotation.FieldOrder;

/**
 * @author Eugene Savin
 */
public class SameLocals1StackItemExtended extends StackMapFrame {

    @FieldOrder(index = 2)
    private short offsetDelta;

    @FieldOrder(index = 3)
    private VerificationTypeInfo stackItem;

    public short getOffsetDelta() {
        return offsetDelta;
    }

    public void setOffsetDelta(short offsetDelta) {
        this.offsetDelta = offsetDelta;
    }

    public VerificationTypeInfo getStackItem() {
        return stackItem;
    }

    public void setStackItem(VerificationTypeInfo stackItem) {
        this.stackItem = stackItem;
    }
}
