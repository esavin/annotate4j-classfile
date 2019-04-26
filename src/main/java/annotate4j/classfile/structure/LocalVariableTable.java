package annotate4j.classfile.structure;

import annotate4j.classfile.structure.constantpool.ConstantPoolItem;
import annotate4j.classfile.structure.constantpool.Utf8Info;
import annotate4j.core.bin.annotation.FieldOrder;

import java.util.List;

/**
 * @author Eugene Savin
 */
public class LocalVariableTable implements HasDescriptorIndex {

    @FieldOrder(index = 1)
    private short startPc;

    @FieldOrder(index = 2)
    private short length;

    @FieldOrder(index = 3)
    private short nameIndex;

    @FieldOrder(index = 4)
    private Short descriptorIndex;

    @FieldOrder(index = 5)
    private short index;

    private List<ConstantPoolItem> constantPoolList;

    public Short getDescriptorIndex() {
        return descriptorIndex;
    }

    public void setDescriptorIndex(Short descriptorIndex) {
        this.descriptorIndex = descriptorIndex;
    }

    public short getIndex() {
        return index;
    }

    public void setIndex(short index) {
        this.index = index;
    }

    public short getLength() {
        return length;
    }

    public void setLength(short length) {
        this.length = length;
    }

    public short getNameIndex() {
        return nameIndex;
    }

    public void setNameIndex(short nameIndex) {
        this.nameIndex = nameIndex;
    }

    public short getStartPc() {
        return startPc;
    }

    public void setStartPc(short startPc) {
        this.startPc = startPc;
    }

    public List<ConstantPoolItem> getConstantPoolList() {
        return constantPoolList;
    }

    public void setConstantPoolList(List<ConstantPoolItem> constantPoolList) {
        this.constantPoolList = constantPoolList;
    }

    @Override
    public String toString() {
        String fieldName = ((Utf8Info) getConstantPoolList().get(nameIndex - 1)).getBytesStr();
        String descriptor = ((Utf8Info) getConstantPoolList().get(descriptorIndex - 1)).getBytesStr();
        return fieldName + "     " + descriptor;
    }
}
