package annotate4j.classfile.structure.attribute;

import annotate4j.classfile.structure.LocalVariableTypeTable;
import annotate4j.core.bin.annotation.ContainerSize;
import annotate4j.core.bin.annotation.FieldOrder;

import java.util.List;

/**
 * @author Eugene Savin
 */
public class LocalVariableTypeTableAttribute extends Attribute {

    @FieldOrder(index = 3)
    private short localVariableTypeTableLength;

    @FieldOrder(index = 4)
    @ContainerSize(fieldName = "localVariableTypeTableLength")
    private List<LocalVariableTypeTable> localVariableTypeTableList;


    public short getLocalVariableTypeTableLength() {
        return localVariableTypeTableLength;
    }

    public void setLocalVariableTypeTableLength(short localVariableTypeTableLength) {
        this.localVariableTypeTableLength = localVariableTypeTableLength;
    }

    public List<LocalVariableTypeTable> getLocalVariableTypeTableList() {
        return localVariableTypeTableList;
    }

    public void setLocalVariableTypeTableList(List<LocalVariableTypeTable> localVariableTypeTableList) {
        this.localVariableTypeTableList = localVariableTypeTableList;
    }
}
