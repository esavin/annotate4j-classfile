package annotate4j.classfile.structure.operation;

import annotate4j.core.annotation.FieldOrder;

/**
 * @author Eugene Savin
 * @version Aug 26, 2010
 */
public class MultianewarrayOperation extends Operation {

    @FieldOrder(index = 2)
    private short index;

    @FieldOrder(index = 3)
    private byte dimensions;

    public String getMnemonic() {
        return "multianewarray";
    }

    public short getIndex() {
        return index;
    }

    public void setIndex(short index) {
        this.index = index;
    }

    public byte getDimensions() {
        return dimensions;
    }

    public void setDimensions(byte dimensions) {
        this.dimensions = dimensions;
    }

    @Override
    public String toString() {
        return super.toString() + " " + index + " " + dimensions;    
    }
}
