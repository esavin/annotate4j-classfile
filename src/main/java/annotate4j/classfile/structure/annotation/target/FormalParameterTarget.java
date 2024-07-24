package annotate4j.classfile.structure.annotation.target;

import annotate4j.core.bin.annotation.FieldOrder;

public class FormalParameterTarget extends TargetTypeAndInfo {

    @FieldOrder(index = 2)
    private byte formalParameterIndex;

    public byte getFormalParameterIndex() {
        return formalParameterIndex;
    }

    public void setFormalParameterIndex(byte formalParameterIndex) {
        this.formalParameterIndex = formalParameterIndex;
    }
}
