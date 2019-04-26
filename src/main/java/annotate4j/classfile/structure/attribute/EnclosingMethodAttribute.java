package annotate4j.classfile.structure.attribute;

import annotate4j.core.bin.annotation.FieldOrder;

/**
 * @author Eugene Savin
 */
public class EnclosingMethodAttribute extends Attribute {

    @FieldOrder(index = 3)
    private short classIndex;

    @FieldOrder(index = 4)
    private short methodIndex;

    public short getClassIndex() {
        return classIndex;
    }

    public void setClassIndex(short classIndex) {
        this.classIndex = classIndex;
    }

    public short getMethodIndex() {
        return methodIndex;
    }

    public void setMethodIndex(short methodIndex) {
        this.methodIndex = methodIndex;
    }
}
