package annotate4j.classfile.structure.attribute;

import annotate4j.core.bin.annotation.FieldOrder;

public class Parameter {

    @FieldOrder(index = 1)
    private short nameIndex;

    @FieldOrder(index = 2)
    private short accessFlags;

    public short getNameIndex() {
        return nameIndex;
    }

    public void setNameIndex(short nameIndex) {
        this.nameIndex = nameIndex;
    }

    public short getAccessFlags() {
        return accessFlags;
    }

    public void setAccessFlags(short accessFlags) {
        this.accessFlags = accessFlags;
    }
}
