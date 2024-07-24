package annotate4j.classfile.structure.attribute;

import annotate4j.core.bin.annotation.FieldOrder;

public class ModuleMainClassAttribute extends Attribute {

    @FieldOrder(index = 3)
    private short mainClasIndex;

    public short getMainClasIndex() {
        return mainClasIndex;
    }

    public void setMainClasIndex(short mainClasIndex) {
        this.mainClasIndex = mainClasIndex;
    }
}
