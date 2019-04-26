package annotate4j.classfile.structure.attribute;

import annotate4j.classfile.structure.annotation.Annotation;
import annotate4j.core.bin.annotation.ContainerSize;
import annotate4j.core.bin.annotation.FieldOrder;

import java.util.List;

/**
 * @author Eugene Savin
 */
public class RuntimeInvisibleAnnotationsAttribute extends Attribute {

    @FieldOrder(index = 3)
    private short annotationsCount;


    @FieldOrder(index = 4)
    @ContainerSize(fieldName = "annotationsCount")
    private List<Annotation> annotationList;


    public List<Annotation> getAnnotationList() {
        return annotationList;
    }

    public void setAnnotationList(List<Annotation> annotationList) {
        this.annotationList = annotationList;
    }

    public short getAnnotationsCount() {
        return annotationsCount;
    }

    public void setAnnotationsCount(short annotationsCount) {
        this.annotationsCount = annotationsCount;
    }
}
