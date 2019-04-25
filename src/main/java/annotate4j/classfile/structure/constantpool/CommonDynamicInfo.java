package annotate4j.classfile.structure.constantpool;

import annotate4j.core.annotation.FieldOrder;

public class CommonDynamicInfo extends ConstantPoolItem {

    /**
     * The value of the bootstrap_method_attr_index item must be a valid index
     * into the bootstrap_methods array of the bootstrap method table of this class
     * file (§4.7.23).
     */
    @FieldOrder(index = 2)
    private short bootstrapMethodAttrIndex;

    /**
     * The value of the name_and_type_index item must be a valid index into
     * the constant_pool table. The constant_pool entry at that index must be a
     * CONSTANT_NameAndType_info structure (§4.4.6). This constant_pool entry
     * indicates a name and descriptor.
     */
    @FieldOrder(index = 3)
    private short nameAndTypeIndex;

    public short getBootstrapMethodAttrIndex() {
        return bootstrapMethodAttrIndex;
    }

    public void setBootstrapMethodAttrIndex(short bootstrapMethodAttrIndex) {
        this.bootstrapMethodAttrIndex = bootstrapMethodAttrIndex;
    }

    public short getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }

    public void setNameAndTypeIndex(short nameAndTypeIndex) {
        this.nameAndTypeIndex = nameAndTypeIndex;
    }
}
