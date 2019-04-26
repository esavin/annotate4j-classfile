package annotate4j.classfile.structure.constantpool;

import annotate4j.core.bin.annotation.ContainerSize;
import annotate4j.core.bin.annotation.FieldOrder;

import java.util.List;

/**
 * @author Eugene Savin
 */
public class ConstantPoolContainer {
    @FieldOrder(index = 1)
    private short constantPoolCount;

    @FieldOrder(index = 2)
    @ContainerSize(fieldName = "constantPoolCount", corrector = -1)
    private List<ConstantPoolItem> constantPoolList;

    public short getConstantPoolCount() {
        return constantPoolCount;
    }

    public void setConstantPoolCount(short constantPoolCount) {
        this.constantPoolCount = constantPoolCount;
    }

    public List<ConstantPoolItem> getConstantPoolList() {
        return constantPoolList;
    }

    public void setConstantPoolList(List<ConstantPoolItem> constantPoolList) {
        this.constantPoolList = constantPoolList;
    }
}
