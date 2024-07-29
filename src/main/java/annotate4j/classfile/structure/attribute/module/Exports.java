package annotate4j.classfile.structure.attribute.module;

import annotate4j.core.bin.annotation.ContainerSize;
import annotate4j.core.bin.annotation.FieldOrder;

import java.util.List;

public class Exports {

    @FieldOrder(index = 1)
    private short exportsIndex;

    @FieldOrder(index = 2)
    private short exportsFlags;

    @FieldOrder(index = 3)
    private short exportsToCount;

    @FieldOrder(index = 4)
    @ContainerSize(fieldName = "exportsToCount")
    private List<Short> exportsToIndex;

    public short getExportsIndex() {
        return exportsIndex;
    }

    public void setExportsIndex(short exportsIndex) {
        this.exportsIndex = exportsIndex;
    }

    public short getExportsFlags() {
        return exportsFlags;
    }

    public void setExportsFlags(short exportsFlags) {
        this.exportsFlags = exportsFlags;
    }

    public short getExportsToCount() {
        return exportsToCount;
    }

    public void setExportsToCount(short exportsToCount) {
        this.exportsToCount = exportsToCount;
    }

    public List<Short> getExportsToIndex() {
        return exportsToIndex;
    }

    public void setExportsToIndex(List<Short> exportsToIndex) {
        this.exportsToIndex = exportsToIndex;
    }
}
