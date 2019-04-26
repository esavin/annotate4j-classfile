package annotate4j.classfile.structure.attribute;

import annotate4j.classfile.structure.LocalVariableTable;
import annotate4j.core.bin.annotation.ContainerSize;
import annotate4j.core.bin.annotation.FieldOrder;
import annotate4j.core.bin.annotation.Inject;

import java.util.List;

/**
 * @author Eugene Savin
 */
public class LocalVariableTableAttribute extends Attribute {

    @FieldOrder(index = 3)
    private short localVariableTableLength;

    @FieldOrder(index = 4)
    @ContainerSize(fieldName = "localVariableTableLength")
    @Inject(fieldName = "constantPoolList")
    private List<LocalVariableTable> localVariableTableList;

    public short getLocalVariableTableLength() {
        return localVariableTableLength;
    }

    public void setLocalVariableTableLength(short localVariableTableLength) {
        this.localVariableTableLength = localVariableTableLength;
    }

    public List<LocalVariableTable> getLocalVariableTableList() {
        return localVariableTableList;
    }

    public void setLocalVariableTableList(List<LocalVariableTable> localVariableTableList) {
        this.localVariableTableList = localVariableTableList;
    }
}
