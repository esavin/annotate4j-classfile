package annotate4j.classfile.structure.stackmapframe;

import annotate4j.classfile.structure.stackmapframe.vti.VerificationTypeInfo;
import annotate4j.core.bin.annotation.ContainerSize;
import annotate4j.core.bin.annotation.FieldOrder;

import java.util.List;

/**
 * @author Eugene Savin
 */
public class AppendFrame extends StackMapFrame {

    @FieldOrder(index = 2)
    private short offsetDelta;

    @FieldOrder(index = 3)
    @ContainerSize(fieldName = "frameType", corrector = -251)
    private List<VerificationTypeInfo> locals;

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
}
