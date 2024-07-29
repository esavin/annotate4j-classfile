package annotate4j.classfile.structure.attribute.module;

import annotate4j.core.bin.annotation.ContainerSize;
import annotate4j.core.bin.annotation.FieldOrder;

import java.util.List;

public class Opens {

    @FieldOrder(index = 1)
    private short opensIndex;

    @FieldOrder(index = 2)
    private short opensFlags;

    @FieldOrder(index = 3)
    private short opensToCount;

    @FieldOrder(index = 4)
    @ContainerSize(fieldName = "opensToCount")
    private List<Short> opensToIndex;

    public short getOpensIndex() {
        return opensIndex;
    }

    public void setOpensIndex(short opensIndex) {
        this.opensIndex = opensIndex;
    }

    public short getOpensFlags() {
        return opensFlags;
    }

    public void setOpensFlags(short opensFlags) {
        this.opensFlags = opensFlags;
    }

    public short getOpensToCount() {
        return opensToCount;
    }

    public void setOpensToCount(short opensToCount) {
        this.opensToCount = opensToCount;
    }

    public List<Short> getOpensToIndex() {
        return opensToIndex;
    }

    public void setOpensToIndex(List<Short> opensToIndex) {
        this.opensToIndex = opensToIndex;
    }
}
