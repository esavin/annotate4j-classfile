package annotate4j.classfile.structure.stackmapframe.vti;

import annotate4j.core.HasInheritor;
import annotate4j.core.annotation.FieldOrder;
import annotate4j.core.exceptions.InheritorNotFoundException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Eugene Savin
 */

public class VerificationTypeInfo implements HasInheritor<VerificationTypeInfo> {
    private static final Map<String, Class<? extends VerificationTypeInfo>> m = new HashMap<String, Class<? extends VerificationTypeInfo>>();

    static {
        m.put("ITEM_Top", ItemTop.class);
        m.put("ITEM_Integer", ItemInteger.class);
        m.put("ITEM_Float", ItemFloat.class);
        m.put("ITEM_Double", ItemDouble.class);
        m.put("ITEM_Long", ItemLong.class);
        m.put("ITEM_Null", ItemNull.class);
        m.put("ITEM_UninitializedThis", ItemUninitializedThis.class);
        m.put("ITEM_Object", ItemObject.class);
        m.put("ITEM_Uninitialized", ItemUninitialized.class);
    }

    @FieldOrder(index = 1)
    private byte tag;

    public byte getTag() {
        return tag;
    }

    public void setTag(byte tag) {
        this.tag = tag;
    }

    @Override
    public Class<? extends VerificationTypeInfo> getInheritor() throws InheritorNotFoundException {
        String str = null;
        switch (tag) {
            case 0:
                str = "ITEM_Top";
                break;
            case 1:
                str = "ITEM_Integer";
                break;
            case 2:
                str = "ITEM_Float";
                break;
            case 3:
                str = "ITEM_Double";
                break;
            case 4:
                str = "ITEM_Long";
                break;
            case 5:
                str = "ITEM_Null";
                break;
            case 6:
                str = "ITEM_UninitializedThis";
                break;
            case 7:
                str = "ITEM_Object";
                break;
            case 8:
                str = "ITEM_Uninitialized";
                break;
        }
        if (str == null) {
            throw new InheritorNotFoundException(this.getClass().getName(), String.valueOf(tag));
        }
        return m.get(str);
    }

    @Override
    public Collection<Class<? extends VerificationTypeInfo>> getInheritors() {
        return m.values();
    }
}
