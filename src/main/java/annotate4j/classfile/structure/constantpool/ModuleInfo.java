package annotate4j.classfile.structure.constantpool;

import annotate4j.core.annotation.FieldOrder;

/**
 * The CONSTANT_Module_info structure is used to represent a module
 */
public class ModuleInfo extends ConstantPoolItem {

    /**
     * The value of the name_index item must be a valid index into the
     * constant_pool table. The constant_pool entry at that index must be a
     * CONSTANT_Utf8_info structure (§4.4.7) representing a valid module name
     * (§4.2.3).
     */
    @FieldOrder(index = 2)
    private short nameIndex;


    public short getNameIndex() {
        return nameIndex;
    }

    public void setNameIndex(short nameIndex) {
        this.nameIndex = nameIndex;
    }
}
