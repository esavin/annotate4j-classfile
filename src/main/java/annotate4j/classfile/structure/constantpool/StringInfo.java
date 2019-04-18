package annotate4j.classfile.structure.constantpool;

import annotate4j.core.annotation.FieldOrder;

/**
 * @author Eugene Savin
 */
public class StringInfo extends ConstantPool {

    @FieldOrder(index = 2)
    private short stringIndex;

    public short getStringIndex() {
        return stringIndex;
    }

    public void setStringIndex(short stringIndex) {
        this.stringIndex = stringIndex;
    }

    @Override
    public String toString() {
        return ((Utf8Info)getConstantPoolList().get(stringIndex - 1)).getBytesStr();
    }
}
