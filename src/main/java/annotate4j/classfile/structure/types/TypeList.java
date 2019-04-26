package annotate4j.classfile.structure.types;

import annotate4j.core.bin.annotation.FieldOrder;

import java.util.List;

/**
 * The TypeList instance used to describe parameter list for methods
 */

public class TypeList {

    @FieldOrder(index = 1)
    private List<Type> typeList;

    public List<Type> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<Type> typeList) {
        this.typeList = typeList;
    }
}
