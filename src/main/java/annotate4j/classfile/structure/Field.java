package annotate4j.classfile.structure;

import annotate4j.classfile.structure.attribute.Attribute;
import annotate4j.classfile.structure.constantpool.ConstantPool;
import annotate4j.classfile.structure.constantpool.Utf8Info;
import annotate4j.classfile.structure.types.Type;
import annotate4j.core.Loader;
import annotate4j.core.annotation.FieldOrder;
import annotate4j.core.bin.annotation.ContainerSize;
import annotate4j.core.bin.annotation.Inject;
import annotate4j.core.bin.exceptions.FieldReadException;
import annotate4j.core.bin.loader.InputStreamLoader;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Eugene Savin
 */
public class Field implements HasDescriptorIndex, HasAttributeList {

    private final static Map<Short, String> fieldAccessPropertiesMap;
    private final static Map<String, String> primitiveTypes;
    static {
        fieldAccessPropertiesMap = new HashMap<>();
        fieldAccessPropertiesMap.put((short) 0x0001, "public");
        fieldAccessPropertiesMap.put((short) 0x0002, "private");
        fieldAccessPropertiesMap.put((short)0x0004, "protected");
        fieldAccessPropertiesMap.put((short)0x0008, "static");
        fieldAccessPropertiesMap.put((short)0x0010, "final");
        fieldAccessPropertiesMap.put((short)0x0040, "volatile");
        fieldAccessPropertiesMap.put((short)0x0080, "transient");
        fieldAccessPropertiesMap.put((short)0x4000, "ACC_ENUM"); // Declared as an element of an enum.
        fieldAccessPropertiesMap.put((short)0x1000, "ACC_SYNTHETIC"); // Declared synthetic; not present in the source code.

        primitiveTypes = new HashMap<>();
        primitiveTypes.put("B", "byte");
        primitiveTypes.put("C", "char");
        primitiveTypes.put("D", "double");
        primitiveTypes.put("F", "float");
        primitiveTypes.put("I", "int");
        primitiveTypes.put("J", "long");
        primitiveTypes.put("S", "short");
        primitiveTypes.put("Z", "boolean");
    }

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

    public String getFieldAccessProperties(){
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Short, String> e: fieldAccessPropertiesMap.entrySet()){
            if ((e.getKey() & accessFlags) == e.getKey()){
                builder.append(e.getValue()).append(" ");
            }
        }
        return builder.toString();
    }

    public static String getType(String descriptor){
        Loader loader = new InputStreamLoader(new ByteArrayInputStream(descriptor.getBytes()), new Type());
        Type type = null;
        try {
            type = (Type) loader.load();
        } catch (FieldReadException e) {
            e.printStackTrace();
        }
        if (type != null){
            return type.getTypeName();
        }
        return "UNKNOWN TYPE";
    }

    @Override
    public String toString() {
        String fieldName = ((Utf8Info) getConstantPoolList().get(nameIndex - 1)).getBytesStr();
        String descriptor = ((Utf8Info)getConstantPoolList().get(descriptorIndex - 1)).getBytesStr();
        return getFieldAccessProperties() + " " + getType(descriptor) + "  " + fieldName + ";";
    }
}
