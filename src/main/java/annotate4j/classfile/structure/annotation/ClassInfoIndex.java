package annotate4j.classfile.structure.annotation;

import annotate4j.core.bin.annotation.FieldOrder;

/**
 * @author Eugene Savin
 */
public class ClassInfoIndex extends ElementValue {

    @FieldOrder(index = 2)
    private short classInfoIndex;

    public short getClassInfoIndex() {
        return classInfoIndex;
    }

    public void setClassInfoIndex(short classInfoIndex) {
        this.classInfoIndex = classInfoIndex;
    }
}
