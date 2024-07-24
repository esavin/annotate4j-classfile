package annotate4j.classfile.structure.attribute;

import annotate4j.classfile.structure.annotation.TypeAnnotation;
import annotate4j.core.bin.annotation.ContainerSize;
import annotate4j.core.bin.annotation.FieldOrder;

import java.util.List;

public class RuntimeInvisibleTypeAnnotationsAttribute extends Attribute {

    @FieldOrder(index = 3)
    private short numAnnotations;

    @FieldOrder(index = 4)
    @ContainerSize(fieldName = "numAnnotations")
    private List<TypeAnnotation> annotations;

    public short getNumAnnotations() {
        return numAnnotations;
    }

    public void setNumAnnotations(short numAnnotations) {
        this.numAnnotations = numAnnotations;
    }

    public List<TypeAnnotation> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<TypeAnnotation> annotations) {
        this.annotations = annotations;
    }
}
