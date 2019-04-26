package annotate4j.classfile.structure.constantpool;

import annotate4j.core.bin.annotation.FieldOrder;

/**
 * @author Eugene Savin
 */
public class CommonRefInfo extends ConstantPoolItem {

    @FieldOrder(index = 2)
    private short classIndex;

    @FieldOrder(index = 3)
    private short nameAndTypeIndex;

    public short getClassIndex() {
        return classIndex;
    }

    public void setClassIndex(short classIndex) {
        this.classIndex = classIndex;
    }

    public short getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }

    public void setNameAndTypeIndex(short nameAndTypeIndex) {
        this.nameAndTypeIndex = nameAndTypeIndex;
    }

    @Override
    public String toString() {
        String className = getConstantPoolList().get(classIndex - 1).toString();
        NameAndTypeInfo nameAndTypeInfo = (NameAndTypeInfo) getConstantPoolList().get(nameAndTypeIndex - 1);
        return className + "  " + nameAndTypeInfo.toString();
    }
}
