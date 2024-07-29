package annotate4j.classfile.structure.attribute.module;

import annotate4j.core.bin.annotation.ContainerSize;
import annotate4j.core.bin.annotation.FieldOrder;

import java.util.List;

public class Provides {

    @FieldOrder(index = 1)
    private short providesIndex;

    @FieldOrder(index = 2)
    private short providesWithCount;

    @FieldOrder(index = 3)
    @ContainerSize(fieldName = "providesWithCount")
    private List<Short> providesWithIndex;

    public short getProvidesIndex() {
        return providesIndex;
    }

    public void setProvidesIndex(short providesIndex) {
        this.providesIndex = providesIndex;
    }

    public short getProvidesWithCount() {
        return providesWithCount;
    }

    public void setProvidesWithCount(short providesWithCount) {
        this.providesWithCount = providesWithCount;
    }

    public List<Short> getProvidesWithIndex() {
        return providesWithIndex;
    }

    public void setProvidesWithIndex(List<Short> providesWithIndex) {
        this.providesWithIndex = providesWithIndex;
    }
}
