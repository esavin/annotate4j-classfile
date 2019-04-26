package annotate4j.classfile.structure.operation;

import annotate4j.core.bin.annotation.FieldOrder;
import annotate4j.core.bin.annotation.Inject;

import java.util.List;

public class OperationList {

    private byte[] code;

    private static Integer codePosition;


    public OperationList(byte[] code) {
        this.code = code;
        codePosition = 0;
    }

    @FieldOrder(index = 1)
    @Inject(fieldName = "code")
    List<Operation> operations;

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public byte[] getCode() {
        return code;
    }

    public OperationList getOperationList() {
        return this;
    }

    public static int getCodePosition() {
        return codePosition;
    }

    public static void setCodePosition(int codePosition) {
        OperationList.codePosition = codePosition;
    }
}
