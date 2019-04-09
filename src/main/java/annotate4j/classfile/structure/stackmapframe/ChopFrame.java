package annotate4j.classfile.structure.stackmapframe;

import annotate4j.core.annotation.FieldOrder;

/**
 * @author Eugene Savin
 */
public class ChopFrame extends StackMapFrame {

    @FieldOrder(index = 2)
    private short offsetDelta;

    public short getOffsetDelta() {
        return offsetDelta;
    }

    public void setOffsetDelta(short offsetDelta) {
        this.offsetDelta = offsetDelta;
    }
}
