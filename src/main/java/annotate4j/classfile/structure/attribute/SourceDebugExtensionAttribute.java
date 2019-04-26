package annotate4j.classfile.structure.attribute;

import annotate4j.core.bin.annotation.ContainerSize;
import annotate4j.core.bin.annotation.FieldOrder;

/**
 * @author Eugene Savin
 */
public class SourceDebugExtensionAttribute extends Attribute {

    @FieldOrder(index = 3)
    @ContainerSize(fieldName = "attributeLength")
    private byte[] debugExtension;

    public byte[] getDebugExtension() {
        return debugExtension;
    }

    public void setDebugExtension(byte[] debugExtension) {
        this.debugExtension = debugExtension;
    }
}
