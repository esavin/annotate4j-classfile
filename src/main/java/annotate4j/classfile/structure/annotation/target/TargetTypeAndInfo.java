package annotate4j.classfile.structure.annotation.target;

import annotate4j.core.HasInheritor;
import annotate4j.core.bin.annotation.FieldOrder;
import annotate4j.core.exceptions.InheritorNotFoundException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TargetTypeAndInfo implements HasInheritor<TargetTypeAndInfo> {
    private static final Map<Byte, Class<? extends TargetTypeAndInfo>> m = new HashMap<Byte, Class<? extends TargetTypeAndInfo>>();

    static {

        m.put((byte)0x00, TypeParameterTarget.class);
        m.put((byte)0x01, TypeParameterTarget.class);
        m.put((byte)0x10, SupertypeTarget.class);
        m.put((byte)0x11, TypeParameterBoundTarget.class);
        m.put((byte)0x12, TypeParameterBoundTarget.class);
        m.put((byte)0x13, EmptyTarget.class);
        m.put((byte)0x14, EmptyTarget.class);
        m.put((byte)0x15, EmptyTarget.class);
        m.put((byte)0x16, FormalParameterTarget.class);
        m.put((byte)0x17, ThrowsTarget.class);
        m.put((byte)0x40, LocalvarTarget.class);
        m.put((byte)0x41, LocalvarTarget.class);
        m.put((byte)0x42, CatchTarget.class);
        m.put((byte)0x43, OffsetTarget.class);
        m.put((byte)0x44, OffsetTarget.class);
        m.put((byte)0x45, OffsetTarget.class);
        m.put((byte)0x46, OffsetTarget.class);
        m.put((byte)0x47, TypeArgumentTarget.class);
        m.put((byte)0x48, TypeArgumentTarget.class);
        m.put((byte)0x49, TypeArgumentTarget.class);
        m.put((byte)0x4A, TypeArgumentTarget.class);
        m.put((byte)0x4B, TypeArgumentTarget.class);

    }

    @FieldOrder(index = 1)
    private byte targetType;

    @Override
    public Class<? extends TargetTypeAndInfo> getInheritor() throws InheritorNotFoundException {

        Class<? extends TargetTypeAndInfo> clazz = m.get(targetType);
        if (clazz == null) {
            throw new InheritorNotFoundException(this.getClass().getName(), String.valueOf(targetType));
        }
        return clazz;
    }

    @Override
    public Collection<Class<? extends TargetTypeAndInfo>> getInheritors() {
        return m.values();
    }

    public byte getTargetType() {
        return targetType;
    }

    public void setTargetType(byte targetType) {
        this.targetType = targetType;
    }
}
