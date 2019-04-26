package annotate4j.classfile.structure.types;

import annotate4j.core.bin.annotation.FieldOrder;
import annotate4j.core.bin.annotation.StringTerminator;

public class ClassType extends Type {

    @FieldOrder(index = 2)
    @StringTerminator((byte) ';')
    private String className;

    @Override
    public String getTypeName() {
        return className.replaceAll("/", ".");
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
