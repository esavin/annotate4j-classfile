package annotate4j.classfile.structure.constantpool;

import annotate4j.core.annotation.FieldOrder;

/**
 * The CONSTANT_MethodType_info structure is used to represent a method type:
 */

public class MethodTypeInfo extends ConstantPoolItem {

    /**
     * The value of the descriptor_index item must be a valid index into the
     * constant_pool table. The constant_pool entry at that index must be a
     * CONSTANT_Utf8_info structure (§4.4.7) representing a method descriptor
     * (§4.3.3).
     */
    @FieldOrder(index = 2)
    private short descriptorIndex;


    public short getDescriptorIndex() {
        return descriptorIndex;
    }

    public void setDescriptorIndex(short descriptorIndex) {
        this.descriptorIndex = descriptorIndex;
    }
}
