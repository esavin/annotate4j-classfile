package annotate4j.classfile.structure.annotation;

import annotate4j.core.bin.annotation.FieldOrder;

/**
 * @author Eugene Savin
 */
public class ElementValuePair {

    @FieldOrder(index = 1)
    private short elementNameIndex;

    @FieldOrder(index = 2)
    private ElementValue elementValue;

    public short getElementNameIndex() {
        return elementNameIndex;
    }

    public void setElementNameIndex(short elementNameIndex) {
        this.elementNameIndex = elementNameIndex;
    }

    public ElementValue getElementValue() {
        return elementValue;
    }

    public void setElementValue(ElementValue elementValue) {
        this.elementValue = elementValue;
    }
}
