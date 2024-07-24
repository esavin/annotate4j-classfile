package annotate4j.classfile.structure.operation;

import annotate4j.core.bin.annotation.ContainerSize;
import annotate4j.core.bin.annotation.FieldOrder;

/**
 * @author Eugene Savin
 * @version Aug 26, 2010
 */
public class LookupswitchOperation extends Operation {


    @FieldOrder(index = 2)
    private int paddingBytes;

    @FieldOrder(index = 3)
    private int defaultValue;

    @FieldOrder(index = 4)
    private int npairsCount;

    @FieldOrder(index = 5)
    @ContainerSize(fieldName = "matchOffsetsCount")
    private int[] matchOffsets;

    public LookupswitchOperation() {
        OperationList.setCodePosition(OperationList.getCodePosition() + 1);
    }

    public int getPaddingBytes() {
        return paddingBytes;
    }

    public void setPaddingBytes(int paddingBytes) {
        OperationList.setCodePosition(OperationList.getCodePosition() + getPadding());

        this.paddingBytes = paddingBytes;
    }

    public int getPadding() {
        return 4 - OperationList.getCodePosition() % 4;
    }


    public int getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(int defaultValue) {
        this.defaultValue = defaultValue;
    }

    public int getNpairsCount() {
        return npairsCount;
    }

    public void setNpairsCount(int npairsCount) {
        this.npairsCount = npairsCount;
    }

    public int[] getMatchOffsets() {
        return matchOffsets;
    }

    public void setMatchOffsets(int[] matchOffsets) {
        OperationList.setCodePosition(OperationList.getCodePosition() + matchOffsets.length * 4);
        this.matchOffsets = matchOffsets;
    }

    public int getMatchOffsetsCount() {
        return npairsCount * 2;
    }

    public String getMnemonic() {
        return "lookupswitch";
    }

}
