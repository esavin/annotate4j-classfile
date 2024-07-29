package annotate4j.classfile.structure.attribute.module;

import annotate4j.core.bin.annotation.FieldOrder;

public class Requires {

    @FieldOrder(index = 1)
    private short requiresIndex;

    @FieldOrder(index = 2)
    private short requiresFlags;

    @FieldOrder(index = 3)
    private short requiresVersionIndex;

    public short getRequiresIndex() {
        return requiresIndex;
    }

    public void setRequiresIndex(short requiresIndex) {
        this.requiresIndex = requiresIndex;
    }

    public short getRequiresFlags() {
        return requiresFlags;
    }

    public void setRequiresFlags(short requiresFlags) {
        this.requiresFlags = requiresFlags;
    }

    public short getRequiresVersionIndex() {
        return requiresVersionIndex;
    }

    public void setRequiresVersionIndex(short requiresVersionIndex) {
        this.requiresVersionIndex = requiresVersionIndex;
    }
}
