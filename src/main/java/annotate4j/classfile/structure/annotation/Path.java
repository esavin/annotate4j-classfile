package annotate4j.classfile.structure.annotation;

import annotate4j.core.bin.annotation.FieldOrder;

public class Path {

    @FieldOrder(index = 1)
    private byte type_path_kind;

    @FieldOrder(index = 2)
    private byte type_argument_index;

    public byte getType_path_kind() {
        return type_path_kind;
    }

    public void setType_path_kind(byte type_path_kind) {
        this.type_path_kind = type_path_kind;
    }

    public byte getType_argument_index() {
        return type_argument_index;
    }

    public void setType_argument_index(byte type_argument_index) {
        this.type_argument_index = type_argument_index;
    }
}
