package annotate4j.classfile.structure.attribute;

import annotate4j.classfile.structure.stackmapframe.StackMapFrame;
import annotate4j.core.annotation.FieldOrder;
import annotate4j.core.bin.annotation.ContainerSize;

import java.util.List;

/**
 * @author Eugene Savin
 */
public class StackMapTable extends Attribute {

    @FieldOrder(index = 3)
    private short entriesCount;

    @FieldOrder(index = 4)
    @ContainerSize(fieldName = "entriesCount")
    private List<StackMapFrame> stackMapFrameList;


    public short getEntriesCount() {
        return entriesCount;
    }

    public void setEntriesCount(short entriesCount) {
        this.entriesCount = entriesCount;
    }

    public List<StackMapFrame> getStackMapFrameList() {
        return stackMapFrameList;
    }

    public void setStackMapFrameList(List<StackMapFrame> stackMapFrameList) {
        this.stackMapFrameList = stackMapFrameList;
    }
}
