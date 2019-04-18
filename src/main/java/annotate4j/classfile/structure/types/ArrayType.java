package annotate4j.classfile.structure.types;

import annotate4j.core.annotation.FieldOrder;

public class ArrayType extends Type {

    @FieldOrder(index = 2)
    private Type arrayType;


    @Override
    public String getTypeName() {
        return arrayType.getTypeName() + "[]";
    }

    public Type getArrayType() {
        return arrayType;
    }

    public void setArrayType(Type arrayType) {
        this.arrayType = arrayType;
    }
}
