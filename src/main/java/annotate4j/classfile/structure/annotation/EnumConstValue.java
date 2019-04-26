package annotate4j.classfile.structure.annotation;

import annotate4j.core.bin.annotation.FieldOrder;

/**
 * @author Eugene Savin
 */
public class EnumConstValue extends ElementValue {

    @FieldOrder(index = 2)
    private short typeNameIndex;

    @FieldOrder(index = 3)
    private short constNameIndex;

    public short getConstNameIndex() {
        return constNameIndex;
    }

    public void setConstNameIndex(short constNameIndex) {
        this.constNameIndex = constNameIndex;
    }

    public short getTypeNameIndex() {
        return typeNameIndex;
    }

    public void setTypeNameIndex(short typeNameIndex) {
        this.typeNameIndex = typeNameIndex;
    }
}
