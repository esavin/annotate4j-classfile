package annotate4j.classfile.structure.constantpool;

import annotate4j.core.annotation.FieldOrder;
import annotate4j.core.bin.annotation.ContainerSize;

import java.util.List;

/**
 * @author Eugene Savin
 */
public class ConstantPoolContainer {
    @FieldOrder(index = 1)
    private short constantPoolCount;

    @FieldOrder(index = 2)
    @ContainerSize(fieldName = "constantPoolCount", corrector = -1)
    private List<ConstantPool> constantPoolList;

    public short getConstantPoolCount() {
        return constantPoolCount;
    }

    public void setConstantPoolCount(short constantPoolCount) {
        this.constantPoolCount = constantPoolCount;
    }

    public List<ConstantPool> getConstantPoolList() {
        return constantPoolList;
    }

    public void setConstantPoolList(List<ConstantPool> constantPoolList) {
        this.constantPoolList = constantPoolList;
    }
}
