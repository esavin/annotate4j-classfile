package annotate4j.classfile.structure.constantpool;

import annotate4j.core.bin.annotation.FieldOrder;

/**
 * @author Eugene Savin
 */
public class FourByteNumberInfo extends ConstantPoolItem {

    @FieldOrder(index = 2)
    private int bytes;

    public int getBytes() {
        return bytes;
    }

    public void setBytes(int bytes) {
        this.bytes = bytes;
    }
}
