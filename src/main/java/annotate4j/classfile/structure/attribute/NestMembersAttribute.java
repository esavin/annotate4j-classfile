package annotate4j.classfile.structure.attribute;

import annotate4j.core.bin.annotation.ContainerSize;
import annotate4j.core.bin.annotation.FieldOrder;

import java.util.List;

public class NestMembersAttribute extends Attribute {

    @FieldOrder(index = 3)
    private short numberOfClasses;

    @FieldOrder(index = 4)
    @ContainerSize(fieldName = "numberOfClasses")
    private List<Short> classes;

    public short getNumberOfClasses() {
        return numberOfClasses;
    }

    public void setNumberOfClasses(short numberOfClasses) {
        this.numberOfClasses = numberOfClasses;
    }

    public List<Short> getClasses() {
        return classes;
    }

    public void setClasses(List<Short> classes) {
        this.classes = classes;
    }
}
