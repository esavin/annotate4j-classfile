package annotate4j.classfile.structure.annotation;

import annotate4j.core.bin.annotation.ContainerSize;
import annotate4j.core.bin.annotation.FieldOrder;

import java.util.List;

/**
 * @author Eugene Savin
 */
public class Annotation {

    @FieldOrder(index = 1)
    private short typeIndex;

    @FieldOrder(index = 2)
    private short elementValuePairsCount;

    @FieldOrder(index = 3)
    @ContainerSize(fieldName = "elementValuePairsCount")
    private List<ElementValuePair> elementValuePairList;

    public List<ElementValuePair> getElementValuePairList() {
        return elementValuePairList;
    }

    public void setElementValuePairList(List<ElementValuePair> elementValuePairList) {
        this.elementValuePairList = elementValuePairList;
    }

    public short getElementValuePairsCount() {
        return elementValuePairsCount;
    }

    public void setElementValuePairsCount(short elementValuePairsCount) {
        this.elementValuePairsCount = elementValuePairsCount;
    }

    public short getTypeIndex() {
        return typeIndex;
    }

    public void setTypeIndex(short typeIndex) {
        this.typeIndex = typeIndex;
    }
}
