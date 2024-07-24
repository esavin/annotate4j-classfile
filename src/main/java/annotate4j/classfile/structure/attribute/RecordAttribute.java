package annotate4j.classfile.structure.attribute;

import annotate4j.core.bin.annotation.ContainerSize;
import annotate4j.core.bin.annotation.FieldOrder;

import java.util.List;

public class RecordAttribute extends Attribute {
    @FieldOrder(index = 3)
    private short componentsCount;;

    @FieldOrder(index = 4)
    @ContainerSize(fieldName = "componentsCount")
    private List<RecordComponentInfo> components;

    public short getComponentsCount() {
        return componentsCount;
    }

    public void setComponentsCount(short componentsCount) {
        this.componentsCount = componentsCount;
    }

    public List<RecordComponentInfo> getComponents() {
        return components;
    }

    public void setComponents(List<RecordComponentInfo> components) {
        this.components = components;
    }
}
