package annotate4j.classfile.structure.stackmapframe;

/**
 * @author Eugene Savin
 */
public class SameFrame extends StackMapFrame {

    public short getOffsetDelta() {
        return getFrameType();
    }
}
