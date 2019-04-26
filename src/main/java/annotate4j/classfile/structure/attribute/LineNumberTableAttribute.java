package annotate4j.classfile.structure.attribute;

import annotate4j.classfile.structure.LineNumberTable;
import annotate4j.core.bin.annotation.ContainerSize;
import annotate4j.core.bin.annotation.FieldOrder;

import java.util.List;

/**
 * @author Eugene Savin
 */
public class LineNumberTableAttribute extends Attribute {

    @FieldOrder(index = 3)
    private short lineNumberTableLength;

    @FieldOrder(index = 4)
    @ContainerSize(fieldName = "lineNumberTableLength")
    private List<LineNumberTable> lineNumberTableList;

    public short getLineNumberTableLength() {
        return lineNumberTableLength;
    }

    public void setLineNumberTableLength(short lineNumberTableLength) {
        this.lineNumberTableLength = lineNumberTableLength;
    }

    public List<LineNumberTable> getLineNumberTableList() {
        return lineNumberTableList;
    }

    public void setLineNumberTableList(List<LineNumberTable> lineNumberTableList) {
        this.lineNumberTableList = lineNumberTableList;
    }
}
