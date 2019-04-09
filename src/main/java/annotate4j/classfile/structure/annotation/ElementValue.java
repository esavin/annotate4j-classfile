package annotate4j.classfile.structure.annotation;

import annotate4j.core.HasInheritor;
import annotate4j.core.annotation.FieldOrder;
import annotate4j.core.exceptions.InheritorNotFoundException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Eugene Savin
 */

public class ElementValue implements HasInheritor<ElementValue> {
    private static final Map<String, Class<? extends ElementValue>> m = new HashMap<String, Class<? extends ElementValue>>();

    static {

        m.put("const_value_index", ConstValueIndex.class);
        m.put("enum_const_value", EnumConstValue.class);
        m.put("class_info_index", ClassInfoIndex.class);
        m.put("annotation_value", AnnotationValue.class);
        m.put("array_value", ArrayValue.class);
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
    public Class<? extends ElementValue> getInheritor() throws InheritorNotFoundException {

        String str = null;
        if (tag == 'B' || tag == 'C' || tag == 'D' || tag == 'F' || tag == 'I'
                || tag == 'J' || tag == 'S' || tag == 'Z' || tag == 's') {
            str = "const_value_index";
        }

        if (tag == 'e') {
            str = "enum_const_value";
        }

        if (tag == 'c') {
            str = "class_info_index";
        }

        if (tag == '@') {
            str = "annotation_value";
        }


        if (tag == '[') {
            str = "array_value";
        }

        if (str == null) {
            throw new InheritorNotFoundException(this.getClass().getName(), String.valueOf(tag));
        }

        return m.get(str);
    }

    @Override
    public Collection<Class<? extends ElementValue>> getInheritors() {
        return m.values();
    }
}
