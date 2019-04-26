package annotate4j.classfile.structure.constantpool;

import annotate4j.core.HasInheritor;
import annotate4j.core.bin.annotation.FieldOrder;
import annotate4j.core.exceptions.InheritorNotFoundException;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Eugene Savin
 */


public class ConstantPoolItem implements HasInheritor<ConstantPoolItem> {
    private final static Map<Byte, Class<? extends ConstantPoolItem>> m = new HashMap<>();

    private List<ConstantPoolItem> constantPoolList;

    static {
        m.put((byte) 7, ClassInfo.class);
        m.put((byte) 9, FieldRefInfo.class);
        m.put((byte) 10, MethodRefInfo.class);
        m.put((byte) 11, InterfaceMethodRefInfo.class);
        m.put((byte) 8, StringInfo.class);
        m.put((byte) 3, IntegerInfo.class);
        m.put((byte) 4, FloatInfo.class);
        m.put((byte) 5, LongInfo.class);
        m.put((byte) 6, DoubleInfo.class);
        m.put((byte) 12, NameAndTypeInfo.class);
        m.put((byte) 1, Utf8Info.class);
        m.put((byte) 15, MethodHandleInfo.class);
        m.put((byte) 16, MethodTypeInfo.class);
        m.put((byte) 17, DynamicInfo.class);
        m.put((byte) 18, InvokeDynamicInfo.class);
        m.put((byte) 19, ModuleInfo.class);
        m.put((byte) 20, PackageInfo.class);
    }

    @FieldOrder(index = 1)
    private byte tag;

    @Override
    public Class<? extends ConstantPoolItem> getInheritor() throws InheritorNotFoundException {
        Class<? extends ConstantPoolItem> clazz = m.get(tag);
        if (clazz == null) {
            throw new InheritorNotFoundException(this.getClass().getName(), String.valueOf(tag));
        }
        return clazz;
    }

    public byte getTag() {
        return tag;
    }

    public void setTag(byte tag) {
        this.tag = tag;
    }

    @Override
    public Collection<Class<? extends ConstantPoolItem>> getInheritors() {
        return m.values();
    }

    public void setConstantPoolList(List<ConstantPoolItem> constantPoolList) {
        this.constantPoolList = constantPoolList;
    }

    public List<ConstantPoolItem> getConstantPoolList() {
        return constantPoolList;
    }
}
