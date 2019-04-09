package annotate4j.classfile.structure.operation;

import annotate4j.core.annotation.FieldOrder;

/**
 * @author Eugene Savin
 * @version Aug 26, 2010
 */
public class JsrWOperation extends Operation {

    @FieldOrder(index = 2)
    private int offset;

    public String getMnemonic() {
        return "jsr_w";
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    @Override
    public String toString() {
        return super.toString() + " " + offset;
    }
}
