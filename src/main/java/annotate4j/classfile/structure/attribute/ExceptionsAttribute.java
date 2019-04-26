package annotate4j.classfile.structure.attribute;

import annotate4j.core.bin.annotation.ContainerSize;
import annotate4j.core.bin.annotation.FieldOrder;

/**
 * @author Eugene Savin
 */
public class ExceptionsAttribute extends Attribute {

    @FieldOrder(index = 3)
    private short exceptionsCount;

    @FieldOrder(index = 4)
    @ContainerSize(fieldName = "exceptionsCount")
    private short[] exceptionIndexTable;

    public short[] getExceptionIndexTable() {
        return exceptionIndexTable;
    }

    public void setExceptionIndexTable(short[] exceptionIndexTable) {
        this.exceptionIndexTable = exceptionIndexTable;
    }

    public short getExceptionsCount() {
        return exceptionsCount;
    }

    public void setExceptionsCount(short exceptionsCount) {
        this.exceptionsCount = exceptionsCount;
    }
}
