package annotate4j.classfile.structure.annotation.target;

import annotate4j.core.bin.annotation.FieldOrder;

public class TypeParameterBoundTarget extends TargetTypeAndInfo {

    @FieldOrder(index = 2)
    private byte typeParameterIndex;

    @FieldOrder(index = 3)
    private byte boundIndex;;

    public byte getTypeParameterIndex() {
        return typeParameterIndex;
    }

    public void setTypeParameterIndex(byte typeParameterIndex) {
        this.typeParameterIndex = typeParameterIndex;
    }

    public byte getBoundIndex() {
        return boundIndex;
    }

    public void setBoundIndex(byte boundIndex) {
        this.boundIndex = boundIndex;
    }
}
