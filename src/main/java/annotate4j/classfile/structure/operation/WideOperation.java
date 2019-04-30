package annotate4j.classfile.structure.operation;

import annotate4j.core.HasInheritor;
import annotate4j.core.bin.annotation.FieldOrder;
import annotate4j.core.exceptions.InheritorNotFoundException;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author Eugene Savin
 * @version Aug 26, 2010
 */


public class WideOperation extends Operation implements HasInheritor<Operation> {



    @FieldOrder(index = 2)
    private byte innerOpcode;

    @Override
    public Class<? extends Operation> getInheritor() throws InheritorNotFoundException {
        if ((innerOpcode >= 21 && innerOpcode <= 25) || (innerOpcode >= 54 && innerOpcode <= 58) || innerOpcode == (byte) 169) {
            return WideFormat1Operation.class;
        } else if (innerOpcode == (byte) 132) {
            return WideFormat2Operation.class;
        } else {
            throw new InheritorNotFoundException(this.getClass().getName(), "inner opcode: " + innerOpcode);
        }
    }

    @Override
    public Collection<Class<? extends Operation>> getInheritors() {
        return Arrays.asList(new Class[]{WideFormat1Operation.class, WideFormat2Operation.class});
    }

    public String getMnemonic() {
        return "wide";
    }

    public byte getInnerOpcode() {
        return innerOpcode;
    }

    public void setInnerOpcode(byte innerOpcode) {
        this.innerOpcode = innerOpcode;
    }
}
