package annotate4j.classfile.structure;

import annotate4j.core.annotation.FieldOrder;

/**
 * @author Eugene Savin
 */
public class InnerClass {

    @FieldOrder(index = 1)
    private short innerClassInfoIndex;

    @FieldOrder(index = 2)
    private short outerClassInfoIndex;

    @FieldOrder(index = 3)
    private short innerNameIndex;

    @FieldOrder(index = 4)
    private short innerClassAccessFlags;

    public short getInnerClassAccessFlags() {
        return innerClassAccessFlags;
    }

    public void setInnerClassAccessFlags(short innerClassAccessFlags) {
        this.innerClassAccessFlags = innerClassAccessFlags;
    }

    public short getInnerClassInfoIndex() {
        return innerClassInfoIndex;
    }

    public void setInnerClassInfoIndex(short innerClassInfoIndex) {
        this.innerClassInfoIndex = innerClassInfoIndex;
    }

    public short getInnerNameIndex() {
        return innerNameIndex;
    }

    public void setInnerNameIndex(short innerNameIndex) {
        this.innerNameIndex = innerNameIndex;
    }

    public short getOuterClassInfoIndex() {
        return outerClassInfoIndex;
    }

    public void setOuterClassInfoIndex(short outerClassInfoIndex) {
        this.outerClassInfoIndex = outerClassInfoIndex;
    }
}
