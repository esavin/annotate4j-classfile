package annotate4j.classfile.structure.stackmapframe;

import annotate4j.classfile.structure.stackmapframe.vti.VerificationTypeInfo;
import annotate4j.core.annotation.FieldOrder;
import annotate4j.core.bin.annotation.ContainerSize;

import java.util.List;

/**
 * @author Eugene Savin
 */
public class FullFrame extends StackMapFrame {

    @FieldOrder(index = 2)
    private short offsetDelta;

    @FieldOrder(index = 3)
    private short localsCount;

    @FieldOrder(index = 4)
    @ContainerSize(fieldName = "localsCount")
    private List<VerificationTypeInfo> locals;

    @FieldOrder(index = 5)
    private short stackItemsCount;

    @FieldOrder(index = 6)
    @ContainerSize(fieldName = "stackItemsCount")
    private List<VerificationTypeInfo> stack;


    public short getOffsetDelta() {
        return offsetDelta;
    }

    public void setOffsetDelta(short offsetDelta) {
        this.offsetDelta = offsetDelta;
    }

    public List<VerificationTypeInfo> getLocals() {
        return locals;
    }

    public void setLocals(List<VerificationTypeInfo> locals) {
        this.locals = locals;
    }

    public short getLocalsCount() {
        return localsCount;
    }

    public void setLocalsCount(short localsCount) {
        this.localsCount = localsCount;
    }

    public short getStackItemsCount() {
        return stackItemsCount;
    }

    public void setStackItemsCount(short stackItemsCount) {
        this.stackItemsCount = stackItemsCount;
    }

    public List<VerificationTypeInfo> getStack() {
        return stack;
    }

    public void setStack(List<VerificationTypeInfo> stack) {
        this.stack = stack;
    }
}
