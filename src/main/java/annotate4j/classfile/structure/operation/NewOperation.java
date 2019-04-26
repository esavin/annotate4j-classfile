package annotate4j.classfile.structure.operation;

import annotate4j.core.bin.annotation.FieldOrder;

/**
 * The unsigned indexbyte1 and indexbyte2 are used to construct an
 * index into the run-time constant pool of the current class (§2.6),
 * where the value of the index is (indexbyte1 << 8) | indexbyte2.
 * The run-time constant pool entry at the index must be a symbolic
 * reference to a class or interface type. The named class or interface
 * type is resolved (§5.4.3.1) and should result in a class type.
 * Memory for a new instance of that class is allocated from the
 * garbage-collected heap, and the instance variables of the new
 * object are initialized to their default initial values (§2.3, §2.4). The
 * objectref, a reference to the instance, is pushed onto the operand
 * stack.
 * On successful resolution of the class, it is initialized if it has not
 * already been initialized (§5.5).
 *
 *
 * @author Eugene Savin
 * @version Aug 26, 2010
 */
public class NewOperation extends Operation {

    public NewOperation() {
        OperationList.setCodePosition(OperationList.getCodePosition() + 3);
    }

    @FieldOrder(index = 2)
    private short index;

    public String getMnemonic() {
        return "new";
    }

    public short getIndex() {
        return index;
    }

    public void setIndex(short index) {
        this.index = index;
    }



    public String toString(){
        return super.toString() + " new " + getClassName(index) + "();";
    }


}
