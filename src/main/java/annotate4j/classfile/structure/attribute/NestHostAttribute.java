package annotate4j.classfile.structure.attribute;

import annotate4j.core.bin.annotation.FieldOrder;

public class NestHostAttribute extends Attribute {

    @FieldOrder(index = 3)
    private short hostClassIndex;

    public short getHostClassIndex() {
        return hostClassIndex;
    }

    public void setHostClassIndex(short hostClassIndex) {
        this.hostClassIndex = hostClassIndex;
    }
}
