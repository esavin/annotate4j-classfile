package annotate4j.classfile.structure.attribute;

import annotate4j.core.bin.annotation.ContainerSize;
import annotate4j.core.bin.annotation.FieldOrder;

import java.util.List;

public class RecordComponentInfo {


    @FieldOrder(index = 1)
    private short nameIndex;

    @FieldOrder(index = 2)
    private short descriptorIndex;

    @FieldOrder(index = 3)
    private short attributesCount;

    @FieldOrder(index = 4)
    @ContainerSize(fieldName = "attributesCount")
    private List<Attribute> attributes;

    public short getNameIndex() {
        return nameIndex;
    }

    public void setNameIndex(short nameIndex) {
        this.nameIndex = nameIndex;
    }

    public short getDescriptorIndex() {
        return descriptorIndex;
    }

    public void setDescriptorIndex(short descriptorIndex) {
        this.descriptorIndex = descriptorIndex;
    }

    public short getAttributesCount() {
        return attributesCount;
    }

    public void setAttributesCount(short attributesCount) {
        this.attributesCount = attributesCount;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }
}
