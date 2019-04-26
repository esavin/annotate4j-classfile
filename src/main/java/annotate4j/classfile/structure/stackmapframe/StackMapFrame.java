package annotate4j.classfile.structure.stackmapframe;

import annotate4j.core.HasInheritor;
import annotate4j.core.bin.annotation.FieldOrder;
import annotate4j.core.exceptions.InheritorNotFoundException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Eugene Savin
 */
public class StackMapFrame implements HasInheritor<StackMapFrame> {
    private static final Map<String, Class<? extends StackMapFrame>> m = new HashMap<String, Class<? extends StackMapFrame>>();

    static {
        m.put("SAME", SameFrame.class);
        m.put("SAME_LOCALS_1_STACK_ITEM", SameLocals1StackItem.class);
        m.put("SAME_LOCALS_1_STACK_ITEM_EXTENDED", SameLocals1StackItemExtended.class);
        m.put("CHOP", ChopFrame.class);
        m.put("SAME_FRAME_EXTENDED", SameFrameExtended.class);
        m.put("APPEND", AppendFrame.class);
        m.put("FULL_FRAME", FullFrame.class);
    }


    @FieldOrder(index = 1)
    private byte frameType;

    public byte getFrameType() {
        return frameType;
    }

    public void setFrameType(byte frameType) {
        this.frameType = frameType;
    }

    public short getOffsetDelta() {
        return 0;
    }

    @Override
    public Class<? extends StackMapFrame> getInheritor() throws InheritorNotFoundException {
        String str = null;
        if (frameType >= (byte) 0 && frameType <= (byte) 63) {
            str = "SAME";
        }
        if (frameType >= (byte) 64 && frameType <= (byte) 127) {
            str = "SAME_LOCALS_1_STACK_ITEM";
        }
        if (frameType == (byte) 247) {
            str = "SAME_LOCALS_1_STACK_ITEM_EXTENDED";
        }
        if (frameType >= (byte) 248 && frameType <= (byte) 250) {
            str = "CHOP";
        }

        if (frameType == (byte) 251) {
            str = "SAME_FRAME_EXTENDED";
        }

        if (frameType >= (byte) 252 && frameType <= (byte) 254) {
            str = "APPEND";
        }

        if (frameType == (byte) 255) {
            str = "FULL_FRAME";
        }
        if (str == null) {
            throw new InheritorNotFoundException(this.getClass().getName(), String.valueOf(frameType));
        }

        return m.get(str);
    }

    @Override
    public Collection<Class<? extends StackMapFrame>> getInheritors() {
        return m.values();
    }
}
