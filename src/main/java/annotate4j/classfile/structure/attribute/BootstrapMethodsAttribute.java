package annotate4j.classfile.structure.attribute;

import annotate4j.core.bin.annotation.ContainerSize;
import annotate4j.core.bin.annotation.FieldOrder;

import java.util.List;

public class BootstrapMethodsAttribute extends Attribute {

    @FieldOrder(index = 3)
    private short numBootstrapMethods;

    @FieldOrder(index = 4)
    @ContainerSize(fieldName = "numBootstrapMethods")
    private List<BootstrapMethod> bootstrapMethods;


    public short getNumBootstrapMethods() {
        return numBootstrapMethods;
    }

    public void setNumBootstrapMethods(short numBootstrapMethods) {
        this.numBootstrapMethods = numBootstrapMethods;
    }

    public List<BootstrapMethod> getBootstrapMethods() {
        return bootstrapMethods;
    }

    public void setBootstrapMethods(List<BootstrapMethod> bootstrapMethods) {
        this.bootstrapMethods = bootstrapMethods;
    }
}
