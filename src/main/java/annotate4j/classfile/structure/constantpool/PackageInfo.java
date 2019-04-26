package annotate4j.classfile.structure.constantpool;

import annotate4j.core.bin.annotation.FieldOrder;

/**
 * The CONSTANT_Package_info structure is used to represent a package exported or
 * opened by a module
 */
public class PackageInfo extends ConstantPoolItem {


    /**
     * The value of the name_index item must be a valid index into the
     * constant_pool table. The constant_pool entry at that index must be a
     * CONSTANT_Utf8_info structure (§4.4.7) representing a valid package name
     * encoded in internal form (§4.2.3).
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
