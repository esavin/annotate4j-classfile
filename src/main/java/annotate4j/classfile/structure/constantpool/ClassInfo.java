package annotate4j.classfile.structure.constantpool;

import annotate4j.core.annotation.FieldOrder;

/**
 * @author Eugene Savin
 */
public class ClassInfo extends ConstantPool {

    @FieldOrder(index = 2)
    private short nameIndex;

    public short getNameIndex() {
        return nameIndex;
    }

    public void setNameIndex(short nameIndex) {
        this.nameIndex = nameIndex;
    }
}
