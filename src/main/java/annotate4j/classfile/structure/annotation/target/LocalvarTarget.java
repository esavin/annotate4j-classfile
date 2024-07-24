package annotate4j.classfile.structure.annotation.target;

import annotate4j.core.bin.annotation.ContainerSize;
import annotate4j.core.bin.annotation.FieldOrder;

import java.util.List;

public class LocalvarTarget extends TargetTypeAndInfo {

    @FieldOrder(index = 2)
    private short tableLength;

    @FieldOrder(index = 3)
    @ContainerSize(fieldName = "tableLength")
    private List<Table> tables;


    public short getTableLength() {
        return tableLength;
    }

    public void setTableLength(short tableLength) {
        this.tableLength = tableLength;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }
}
