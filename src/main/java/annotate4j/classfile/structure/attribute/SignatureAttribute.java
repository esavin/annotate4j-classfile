package annotate4j.classfile.structure.attribute;

import annotate4j.core.annotation.FieldOrder;

/**
 * @author Eugene Savin
 */
public class SignatureAttribute extends Attribute {

    @FieldOrder(index = 3)
    private short signatureIndex;

    public short getSignatureIndex() {
        return signatureIndex;
    }

    public void setSignatureIndex(short signatureIndex) {
        this.signatureIndex = signatureIndex;
    }
}
