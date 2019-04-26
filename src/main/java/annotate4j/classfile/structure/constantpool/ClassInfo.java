package annotate4j.classfile.structure.constantpool;

import annotate4j.core.bin.annotation.FieldOrder;

/**
 * @author Eugene Savin
 */
public class ClassInfo extends ConstantPoolItem {

    @FieldOrder(index = 2)
    private short nameIndex;

    public short getNameIndex() {
        return nameIndex;
    }

    public void setNameIndex(short nameIndex) {
        this.nameIndex = nameIndex;
    }

    @Override
    public String toString() {
        return ((Utf8Info) getConstantPoolList().get(nameIndex-1)).getBytesStr();
    }
}
