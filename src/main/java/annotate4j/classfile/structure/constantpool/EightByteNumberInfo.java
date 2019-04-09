package annotate4j.classfile.structure.constantpool;

import annotate4j.classfile.structure.annotation.EntrySize;
import annotate4j.core.annotation.FieldOrder;

/**
 * @author Eugene Savin
 */
@EntrySize(value = 2, index = 2)
public class EightByteNumberInfo extends ConstantPool {

    @FieldOrder(index = 2)
    private int highBytes;

    @FieldOrder(index = 3)
    private int lowBytes;

    public int getHighBytes() {
        return highBytes;
    }

    public void setHighBytes(int highBytes) {
        this.highBytes = highBytes;
    }

    public int getLowBytes() {
        return lowBytes;
    }

    public void setLowBytes(int lowBytes) {
        this.lowBytes = lowBytes;
    }
}
