package annotate4j.classfile.structure.annotation.target;

import annotate4j.core.bin.annotation.FieldOrder;

public class SupertypeTarget extends TargetTypeAndInfo {

    @FieldOrder(index = 2)
    private short supertypeIndex;;

    public short getSupertypeIndex() {
        return supertypeIndex;
    }

    public void setSupertypeIndex(short supertypeIndex) {
        this.supertypeIndex = supertypeIndex;
    }
}
