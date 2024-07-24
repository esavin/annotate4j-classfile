package annotate4j.classfile.structure.annotation;

import annotate4j.classfile.structure.annotation.target.TargetTypeAndInfo;
import annotate4j.core.bin.annotation.ContainerSize;
import annotate4j.core.bin.annotation.FieldOrder;

import java.util.List;

public class TypeAnnotation {

    @FieldOrder(index = 1)
    private TargetTypeAndInfo targetTypeAndInfo;

    @FieldOrder(index = 2)
    private TypePath typePath;

    @FieldOrder(index = 3)
    private short typeIndex;

    @FieldOrder(index = 4)
    private short elementValuePairsCount;

    @FieldOrder(index = 5)
    @ContainerSize(fieldName = "elementValuePairsCount")
    private List<ElementValuePair> elementValuePairList;

    public TargetTypeAndInfo getTargetTypeAndInfo() {
        return targetTypeAndInfo;
    }

    public void setTargetTypeAndInfo(TargetTypeAndInfo targetTypeAndInfo) {
        this.targetTypeAndInfo = targetTypeAndInfo;
    }

    public TypePath getTypePath() {
        return typePath;
    }

    public void setTypePath(TypePath typePath) {
        this.typePath = typePath;
    }

    public short getTypeIndex() {
        return typeIndex;
    }

    public void setTypeIndex(short typeIndex) {
        this.typeIndex = typeIndex;
    }

    public short getElementValuePairsCount() {
        return elementValuePairsCount;
    }

    public void setElementValuePairsCount(short elementValuePairsCount) {
        this.elementValuePairsCount = elementValuePairsCount;
    }

    public List<ElementValuePair> getElementValuePairList() {
        return elementValuePairList;
    }

    public void setElementValuePairList(List<ElementValuePair> elementValuePairList) {
        this.elementValuePairList = elementValuePairList;
    }
}
