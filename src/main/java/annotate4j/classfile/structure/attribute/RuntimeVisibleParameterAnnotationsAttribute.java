package annotate4j.classfile.structure.attribute;

import annotate4j.classfile.structure.annotation.ParameterAnnotation;
import annotate4j.core.annotation.FieldOrder;
import annotate4j.core.bin.annotation.ContainerSize;

import java.util.List;

/**
 * @author Eugene Savin
 */
public class RuntimeVisibleParameterAnnotationsAttribute extends Attribute {

    @FieldOrder(index = 3)
    private byte parametersCount;

    @FieldOrder(index = 4)
    @ContainerSize(fieldName = "parametersCount")
    private List<ParameterAnnotation> parameterAnnotationList;

    public List<ParameterAnnotation> getParameterAnnotationList() {
        return parameterAnnotationList;
    }

    public void setParameterAnnotationList(List<ParameterAnnotation> parameterAnnotationList) {
        this.parameterAnnotationList = parameterAnnotationList;
    }

    public byte getParametersCount() {
        return parametersCount;
    }

    public void setParametersCount(byte parametersCount) {
        this.parametersCount = parametersCount;
    }
}
