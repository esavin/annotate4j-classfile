package annotate4j.classfile.structure.annotation;

import annotate4j.core.bin.annotation.ContainerSize;
import annotate4j.core.bin.annotation.FieldOrder;

import java.util.List;

public class TypePath {

    @FieldOrder(index = 1)
    private byte pathLength;

    @FieldOrder(index = 2)
    @ContainerSize(fieldName = "pathLength")
    private List<Path> pathList;

    public byte getPathLength() {
        return pathLength;
    }

    public void setPathLength(byte pathLength) {
        this.pathLength = pathLength;
    }

    public List<Path> getPathList() {
        return pathList;
    }

    public void setPathList(List<Path> pathList) {
        this.pathList = pathList;
    }
}
