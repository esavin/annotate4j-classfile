package annotate4j.classfile.structure;

import annotate4j.classfile.structure.attribute.Attribute;
import annotate4j.classfile.structure.constantpool.ConstantPoolItem;
import annotate4j.core.annotation.FieldOrder;
import annotate4j.core.bin.annotation.ContainerSize;
import annotate4j.core.bin.annotation.Inject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eugene Savin
 */
public class ClassFile implements HasAttributeList {

    @FieldOrder(index = 1)
    private int magic;

    @FieldOrder(index = 2)
    private short minorVersion;

    @FieldOrder(index = 3)
    private short majorVersion;

    @FieldOrder(index = 4)
    private short constantPoolCount;

    @FieldOrder(index = 5)
    @ContainerSize(fieldName = "constantPoolCount", corrector = -1)
    @Inject(fieldName = "constantPoolList")
    private List<ConstantPoolItem> constantPoolList = new ArrayList<>();

    @FieldOrder(index = 6)
    private Short accessFlag;

    @FieldOrder(index = 7)
    private Short thisClassIndex;

    @FieldOrder(index = 8)
    private Short superClassIndex;

    @FieldOrder(index = 9)
    private short interfacesCount;

    @FieldOrder(index = 10)
    @ContainerSize(fieldName = "interfacesCount")
    private List<Short> interfaceIndexList;

    @FieldOrder(index = 11)
    private short fieldsCount;

    @FieldOrder(index = 12)
    @ContainerSize(fieldName = "fieldsCount")
    @Inject(fieldName = "constantPoolList")
    private List<Field> fieldList;

    @FieldOrder(index = 13)
    private short methodsCount;

    @FieldOrder(index = 14)
    @ContainerSize(fieldName = "methodsCount")
    @Inject(fieldName = "constantPoolList")
    @Inject(fieldName = "thisClassIndex")
    private List<Method> methodList;

    @FieldOrder(index = 15)
    private short attributesCount;

    @FieldOrder(index = 16)
    @ContainerSize(fieldName = "attributesCount")
    @Inject(fieldName = "constantPoolList")
    private List<Attribute> attributeList;

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public short getMinorVersion() {
        return minorVersion;
    }

    public void setMinorVersion(short minorVersion) {
        this.minorVersion = minorVersion;
    }

    public short getMajorVersion() {
        return majorVersion;
    }

    public void setMajorVersion(short majorVersion) {
        this.majorVersion = majorVersion;
    }

    public short getConstantPoolCount() {
        return constantPoolCount;
    }

    public void setConstantPoolCount(short constantPoolCount) {
        this.constantPoolCount = constantPoolCount;
    }

    public List<ConstantPoolItem> getConstantPoolList() {
        return constantPoolList;
    }

    public void setConstantPoolList(List<ConstantPoolItem> constantPoolList) {
        this.constantPoolList = constantPoolList;
    }

    public Short getAccessFlag() {
        return accessFlag;
    }

    public void setAccessFlag(Short accessFlag) {
        this.accessFlag = accessFlag;
    }

    public Short getThisClassIndex() {
        return thisClassIndex;
    }

    public void setThisClassIndex(Short thisClassIndex) {
        this.thisClassIndex = thisClassIndex;
    }

    public Short getSuperClassIndex() {
        return superClassIndex;
    }

    public void setSuperClassIndex(Short superClassIndex) {
        this.superClassIndex = superClassIndex;
    }

    public short getInterfacesCount() {
        return interfacesCount;
    }

    public void setInterfacesCount(short interfacesCount) {
        this.interfacesCount = interfacesCount;
    }

    public List<Short> getInterfaceIndexList() {
        return interfaceIndexList;
    }

    public void setInterfaceIndexList(List<Short> interfaceIndexList) {
        this.interfaceIndexList = interfaceIndexList;
    }

    public short getFieldsCount() {
        return fieldsCount;
    }

    public void setFieldsCount(short fieldsCount) {
        this.fieldsCount = fieldsCount;
    }

    public List<Field> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<Field> fieldList) {
        this.fieldList = fieldList;
    }

    public short getMethodsCount() {
        return methodsCount;
    }

    public void setMethodsCount(short methodsCount) {
        this.methodsCount = methodsCount;
    }

    public List<Method> getMethodList() {
        return methodList;
    }

    public void setMethodList(List<Method> methodList) {
        this.methodList = methodList;
    }

    public short getAttributesCount() {
        return attributesCount;
    }

    public void setAttributesCount(short attributesCount) {
        this.attributesCount = attributesCount;
    }

    public List<Attribute> getAttributeList() {
        return attributeList;
    }

    public void setAttributeList(List<Attribute> attributeList) {
        this.attributeList = attributeList;
    }
}
