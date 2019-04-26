package annotate4j.classfile.structure.annotation;

import annotate4j.core.bin.annotation.FieldOrder;

/**
 * @author Eugene Savin
 */
public class ConstValueIndex extends ElementValue {

    @FieldOrder(index = 2)
    private short constValueIndex;

    public short getConstValueIndex() {
        return constValueIndex;
    }

    public void setConstValueIndex(short constValueIndex) {
        this.constValueIndex = constValueIndex;
    }
}
