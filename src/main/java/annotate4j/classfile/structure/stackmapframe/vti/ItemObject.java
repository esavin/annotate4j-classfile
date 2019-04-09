package annotate4j.classfile.structure.stackmapframe.vti;

import annotate4j.core.annotation.FieldOrder;

/**
 * @author Eugene Savin
 */
public class ItemObject extends VerificationTypeInfo {

    @FieldOrder(index = 2)
    private short constantPoolIndex;

    public short getConstantPoolIndex() {
        return constantPoolIndex;
    }

    public void setConstantPoolIndex(short constantPoolIndex) {
        this.constantPoolIndex = constantPoolIndex;
    }
}
