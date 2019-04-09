package annotate4j.classfile.structure;

import annotate4j.core.annotation.FieldOrder;

/**
 * @author Eugene Savin
 */
public class LineNumberTable {

    @FieldOrder(index = 1)
    private short startPc;

    @FieldOrder(index = 2)
    private short lineNumber;

    public short getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(short lineNumber) {
        this.lineNumber = lineNumber;
    }

    public short getStartPc() {
        return startPc;
    }

    public void setStartPc(short startPc) {
        this.startPc = startPc;
    }
}
