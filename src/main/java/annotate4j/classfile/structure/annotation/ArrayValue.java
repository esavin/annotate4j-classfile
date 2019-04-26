package annotate4j.classfile.structure.annotation;

import annotate4j.core.bin.annotation.ContainerSize;
import annotate4j.core.bin.annotation.FieldOrder;

import java.util.List;

/**
 * @author Eugene Savin
 */
public class ArrayValue extends ElementValue {

    @FieldOrder(index = 2)
    private short valuesCount;


    @FieldOrder(index = 3)
    @ContainerSize(fieldName = "valuesCount")
    private List<ElementValue> values;

    public List<ElementValue> getValues() {
        return values;
    }

    public void setValues(List<ElementValue> values) {
        this.values = values;
    }

    public short getValuesCount() {
        return valuesCount;
    }

    public void setValuesCount(short valuesCount) {
        this.valuesCount = valuesCount;
    }
}
