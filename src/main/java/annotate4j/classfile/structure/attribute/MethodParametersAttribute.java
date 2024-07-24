package annotate4j.classfile.structure.attribute;

import annotate4j.core.bin.annotation.ContainerSize;
import annotate4j.core.bin.annotation.FieldOrder;

import java.util.List;

public class MethodParametersAttribute extends Attribute {

    @FieldOrder(index = 3)
    private short parametersCount;

    @FieldOrder(index = 4)
    @ContainerSize(fieldName = "parametersCount")
    private List<Parameter> parameters;

    public short getParametersCount() {
        return parametersCount;
    }

    public void setParametersCount(short parametersCount) {
        this.parametersCount = parametersCount;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }
}
