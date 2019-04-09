package annotate4j.classfile.structure;

import annotate4j.classfile.structure.attribute.Attribute;
import annotate4j.classfile.structure.constantpool.ConstantPool;
import annotate4j.core.annotation.FieldOrder;
import annotate4j.core.bin.annotation.ContainerSize;
import annotate4j.core.bin.annotation.Inject;

import java.util.List;

/**
 * @author Eugene Savin
 */
public class Field implements HasDescriptorIndex, HasAttributeList {

    @FieldOrder(index = 1)
    private Short accessFlags;

    @FieldOrder(index = 2)
    private Short nameIndex;

    @FieldOrder(index = 3)
    private Short descriptorIndex;

    @FieldOrder(index = 4)
    private Short attributesCount;

    @FieldOrder(index = 5)
    @ContainerSize(fieldName = "attributesCount")
    @Inject(fieldName = "constantPoolList")
    private List<Attribute> attributeList;

    private List<ConstantPool> constantPoolList;

    public Short getAccessFlags() {
        return accessFlags;
    }

    public void setAccessFlags(Short accessFlags) {
        this.accessFlags = accessFlags;
    }

    public List<Attribute> getAttributeList() {
        return attributeList;
    }

    public void setAttributeList(List<Attribute> attributeList) {
        this.attributeList = attributeList;
    }

    public Short getAttributesCount() {
        return attributesCount;
    }

    public void setAttributesCount(Short attributesCount) {
        this.attributesCount = attributesCount;
    }

    public Short getDescriptorIndex() {
        return descriptorIndex;
    }

    public void setDescriptorIndex(Short descriptorIndex) {
        this.descriptorIndex = descriptorIndex;
    }

    public Short getNameIndex() {
        return nameIndex;
    }

    public void setNameIndex(Short nameIndex) {
        this.nameIndex = nameIndex;
    }

    public List<ConstantPool> getConstantPoolList() {
        return constantPoolList;
    }

    public void setConstantPoolList(List<ConstantPool> constantPoolList) {
        this.constantPoolList = constantPoolList;
    }
}
