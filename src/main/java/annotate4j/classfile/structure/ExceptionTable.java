package annotate4j.classfile.structure;

import annotate4j.core.annotation.FieldOrder;

/**
 * @author Eugene Savin
 */
public class ExceptionTable {

    @FieldOrder(index = 1)
    private short startPc;

    @FieldOrder(index = 2)
    private short endPc;

    @FieldOrder(index = 3)
    private short handlerPc;

    @FieldOrder(index = 4)
    private short catchType;

    public short getCatchType() {
        return catchType;
    }

    public void setCatchType(short catchType) {
        this.catchType = catchType;
    }

    public short getEndPc() {
        return endPc;
    }

    public void setEndPc(short endPc) {
        this.endPc = endPc;
    }

    public short getHandlerPc() {
        return handlerPc;
    }

    public void setHandlerPc(short handlerPc) {
        this.handlerPc = handlerPc;
    }

    public short getStartPc() {
        return startPc;
    }

    public void setStartPc(short startPc) {
        this.startPc = startPc;
    }
}
