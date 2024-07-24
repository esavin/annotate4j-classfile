package annotate4j.classfile.structure.attribute;

import annotate4j.core.bin.annotation.ContainerSize;
import annotate4j.core.bin.annotation.FieldOrder;

import java.util.List;

public class BootstrapMethod {

    @FieldOrder(index = 1)
    private short bootstrapMethodRef;

    @FieldOrder(index = 2)
    private short numBootstrapArguments;


    @FieldOrder(index = 3)
    @ContainerSize(fieldName = "numBootstrapArguments")
    private List<Short> bootstrapArguments;

    public short getBootstrapMethodRef() {
        return bootstrapMethodRef;
    }

    public void setBootstrapMethodRef(short bootstrapMethodRef) {
        this.bootstrapMethodRef = bootstrapMethodRef;
    }

    public short getNumBootstrapArguments() {
        return numBootstrapArguments;
    }

    public void setNumBootstrapArguments(short numBootstrapArguments) {
        this.numBootstrapArguments = numBootstrapArguments;
    }

    public List<Short> getBootstrapArguments() {
        return bootstrapArguments;
    }

    public void setBootstrapArguments(List<Short> bootstrapArguments) {
        this.bootstrapArguments = bootstrapArguments;
    }
}
