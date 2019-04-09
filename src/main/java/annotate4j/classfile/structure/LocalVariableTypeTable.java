package annotate4j.classfile.structure;

import annotate4j.core.annotation.FieldOrder;

/**
 * @author Eugene Savin
 */
public class LocalVariableTypeTable {

    @FieldOrder(index = 1)
    private short startPc;

    @FieldOrder(index = 2)
    private short length;

    @FieldOrder(index = 3)
    private short nameIndex;

    @FieldOrder(index = 4)
    private short signatureIndex;

    @FieldOrder(index = 5)
    private short index;

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

    public short getSignatureIndex() {
        return signatureIndex;
    }

    public void setSignatureIndex(short signatureIndex) {
        this.signatureIndex = signatureIndex;
    }

    public short getStartPc() {
        return startPc;
    }

    public void setStartPc(short startPc) {
        this.startPc = startPc;
    }
}
