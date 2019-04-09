package annotate4j.classfile.structure.constantpool;

import annotate4j.classfile.structure.HasDescriptorIndex;
import annotate4j.core.annotation.FieldOrder;

/**
 * @author Eugene Savin
 */
public class NameAndTypeInfo extends ConstantPool implements HasDescriptorIndex {

    @FieldOrder(index = 2)
    private short nameIndex;

    @FieldOrder(index = 3)
    private Short descriptorIndex;

    public Short getDescriptorIndex() {
        return descriptorIndex;
    }

    public void setDescriptorIndex(Short descriptorIndex) {
        this.descriptorIndex = descriptorIndex;
    }

    public short getNameIndex() {
        return nameIndex;
    }

    public void setNameIndex(short nameIndex) {
        this.nameIndex = nameIndex;
    }
}
