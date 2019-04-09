package annotate4j.classfile.structure.attribute;

import annotate4j.classfile.structure.annotation.ElementValue;
import annotate4j.core.annotation.FieldOrder;

/**
 * @author Eugene Savin
 */
public class AnnotationDefaultAttribute extends Attribute {

    @FieldOrder(index = 3)
    private ElementValue defaultValue;

    public ElementValue getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(ElementValue defaultValue) {
        this.defaultValue = defaultValue;
    }
}
