package annotate4j.classfile.structure.attribute;

import annotate4j.core.bin.annotation.ContainerSize;
import annotate4j.core.bin.annotation.FieldOrder;

import java.util.List;

public class ModulePackagesAttribute extends Attribute {

    @FieldOrder(index = 3)
    private short packageCount;

    @FieldOrder(index = 4)
    @ContainerSize(fieldName = "packageCount")
    private List<Short> packageIndex;

    public short getPackageCount() {
        return packageCount;
    }

    public void setPackageCount(short packageCount) {
        this.packageCount = packageCount;
    }

    public List<Short> getPackageIndex() {
        return packageIndex;
    }

    public void setPackageIndex(List<Short> packageIndex) {
        this.packageIndex = packageIndex;
    }
}
