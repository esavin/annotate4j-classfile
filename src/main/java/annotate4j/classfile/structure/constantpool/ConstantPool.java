package annotate4j.classfile.structure.constantpool;

import annotate4j.core.HasInheritor;
import annotate4j.core.annotation.FieldOrder;
import annotate4j.core.exceptions.InheritorNotFoundException;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Eugene Savin
 */


public class ConstantPool implements HasInheritor<ConstantPool> {
    private final static Map<Byte, Class<? extends ConstantPool>> m = new HashMap<Byte, Class<? extends ConstantPool>>();

    private List<ConstantPool> constantPoolList;

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
    }

    @FieldOrder(index = 1)
    private byte tag;

    @Override
    public Class<? extends ConstantPool> getInheritor() throws InheritorNotFoundException {
        Class<? extends ConstantPool> clazz = m.get(tag);
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
    public Collection<Class<? extends ConstantPool>> getInheritors() {
        return m.values();
    }

    public void setConstantPoolList(List<ConstantPool> constantPoolList) {
        this.constantPoolList = constantPoolList;
    }

    public List<ConstantPool> getConstantPoolList() {
        return constantPoolList;
    }
}
