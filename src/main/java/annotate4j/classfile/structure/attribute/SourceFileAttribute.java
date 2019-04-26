package annotate4j.classfile.structure.attribute;

import annotate4j.core.bin.annotation.FieldOrder;

/**
 * @author Eugene Savin
 */
public class SourceFileAttribute extends Attribute {

    @FieldOrder(index = 3)
    private short sourceFileIndex;

    public short getSourceFileIndex() {
        return sourceFileIndex;
    }

    public void setSourceFileIndex(short sourceFileIndex) {
        this.sourceFileIndex = sourceFileIndex;
    }
}
