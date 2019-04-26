package annotate4j.classfile.structure.annotation;

import annotate4j.core.bin.annotation.FieldOrder;

/**
 * @author Eugene Savin
 */
public class AnnotationValue extends ElementValue {

    @FieldOrder(index = 2)
    private Annotation annotationValue;

    public Annotation getAnnotationValue() {
        return annotationValue;
    }

    public void setAnnotationValue(Annotation annotationValue) {
        this.annotationValue = annotationValue;
    }
}
