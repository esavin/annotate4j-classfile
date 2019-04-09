package annotate4j.classfile.structure.attribute;

import annotate4j.core.annotation.FieldOrder;

/**
 * @author Eugene Savin
 */
public class ConstantValueAttribute extends Attribute {

    @FieldOrder(index = 3)
    private short constantValueIndex;

    public short getConstantValueIndex() {
        return constantValueIndex;
    }

    public void setConstantValueIndex(short constantValueIndex) {
        this.constantValueIndex = constantValueIndex;
    }
}
