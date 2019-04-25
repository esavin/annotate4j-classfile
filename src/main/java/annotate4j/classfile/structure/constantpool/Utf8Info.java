package annotate4j.classfile.structure.constantpool;

import annotate4j.core.annotation.FieldOrder;
import annotate4j.core.bin.annotation.ContainerSize;

/**
 * @author Eugene Savin
 */
public class Utf8Info extends ConstantPoolItem {

    @FieldOrder(index = 2)
    private short length;

    @FieldOrder(index = 3)
    @ContainerSize(fieldName = "length")
    private byte[] bytes;

    private String bytesStr;

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
        this.bytesStr = new String(bytes);
    }

    public short getLength() {
        return length;
    }

    public void setLength(short length) {
        this.length = length;
    }

    public String getBytesStr() {
        return bytesStr;
    }

    @Override
    public String toString() {
        return bytesStr;
    }
}
