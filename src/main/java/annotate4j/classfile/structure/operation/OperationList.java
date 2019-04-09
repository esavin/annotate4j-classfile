package annotate4j.classfile.structure.operation;

import annotate4j.core.annotation.FieldOrder;

import java.util.List;

public class OperationList {

    @FieldOrder(index = 1)
    List<Operation> operations;

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }
}
