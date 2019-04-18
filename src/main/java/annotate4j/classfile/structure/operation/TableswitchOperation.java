package annotate4j.classfile.structure.operation;

import annotate4j.core.annotation.FieldOrder;
import annotate4j.core.bin.annotation.ContainerSize;

/**
 * @author Eugene Savin
 * @version Aug 26, 2010
 */
public class TableswitchOperation extends Operation {


    @FieldOrder(index = 1)
    @ContainerSize(fieldName = "padding")
    private byte[] paddingBytes;

    @FieldOrder(index = 2)
    private int defaultValue;

    @FieldOrder(index = 3)
    private int lowValue;

    @FieldOrder(index = 4)
    private int highValue;


    @FieldOrder(index = 5)
    @ContainerSize(fieldName = "jumpOffsetsCount")
    private int[] jumpOffsets;

    public TableswitchOperation() {
        OperationList.setCodePosition(OperationList.getCodePosition() + 1);
    }

    public byte[] getPaddingBytes() {
        return paddingBytes;
    }

    public void setPaddingBytes(byte[] paddingBytes) {
        OperationList.setCodePosition(OperationList.getCodePosition() + getPadding());

        this.paddingBytes = paddingBytes;
    }

    public int getPadding() {
        return 4 - OperationList.getCodePosition() % 4;
    }

    public int getJumpOffsetsCount() {
        return highValue - lowValue + 1;
    }

    public int getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(int defaultValue) {
        this.defaultValue = defaultValue;
    }

    public int getLowValue() {
        return lowValue;
    }

    public void setLowValue(int lowValue) {
        this.lowValue = lowValue;
    }

    public int getHighValue() {
        return highValue;
    }

    public void setHighValue(int highValue) {
        this.highValue = highValue;
    }

    public int[] getJumpOffsets() {
        return jumpOffsets;
    }

    public void setJumpOffsets(int[] jumpOffsets) {
        OperationList.setCodePosition(OperationList.getCodePosition() + jumpOffsets.length * 4);
        this.jumpOffsets = jumpOffsets;
    }

    public String getMnemonic() {
        return "tableswitch";
    }

}
