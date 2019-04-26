package annotate4j.classfile.structure.attribute;

import annotate4j.classfile.structure.InnerClass;
import annotate4j.core.bin.annotation.ContainerSize;
import annotate4j.core.bin.annotation.FieldOrder;

import java.util.List;

/**
 * @author Eugene Savin
 */
public class InnerClassesAttribute extends Attribute {

    @FieldOrder(index = 3)
    private short classesCount;

    @FieldOrder(index = 4)
    @ContainerSize(fieldName = "classesCount")
    private List<InnerClass> innerClassList;

    public short getClassesCount() {
        return classesCount;
    }

    public void setClassesCount(short classesCount) {
        this.classesCount = classesCount;
    }

    public List<InnerClass> getInnerClassList() {
        return innerClassList;
    }

    public void setInnerClassList(List<InnerClass> innerClassList) {
        this.innerClassList = innerClassList;
    }
}
