package annotate4j.classfile.structure.attribute;

import annotate4j.classfile.structure.ExceptionTable;
import annotate4j.classfile.structure.HasAttributeList;
import annotate4j.classfile.structure.operation.Operation;
import annotate4j.classfile.structure.operation.OperationList;
import annotate4j.core.Loader;
import annotate4j.core.bin.annotation.ContainerSize;
import annotate4j.core.bin.annotation.FieldOrder;
import annotate4j.core.bin.annotation.Inject;
import annotate4j.core.bin.exceptions.FieldReadException;
import annotate4j.core.bin.loader.InputStreamLoader;

import java.io.ByteArrayInputStream;
import java.util.List;

/**
 * @author Eugene Savin
 */
public class CodeAttribute extends Attribute implements HasAttributeList {

    @FieldOrder(index = 3)
    private short maxStack;

    @FieldOrder(index = 4)
    private short maxLocals;

    @FieldOrder(index = 5)
    private int codeLength;

    @FieldOrder(index = 6)
    @ContainerSize(fieldName = "codeLength")
    private byte[] code;

    private transient OperationList operationList;

    @FieldOrder(index = 7)
    private short exceptionTableLength;

    @FieldOrder(index = 8)
    @ContainerSize(fieldName = "exceptionTableLength")
    private List<ExceptionTable> exceptionTableList;

    @FieldOrder(index = 9)
    private short attributesCount;

    @FieldOrder(index = 10)
    @ContainerSize(fieldName = "attributesCount")
    @Inject(fieldName = "constantPoolList")
    private List<Attribute> attributeList;

    public List<Attribute> getAttributeList() {
        return attributeList;
    }

    public void setAttributeList(List<Attribute> attributeList) {
        this.attributeList = attributeList;
    }

    public short getAttributesCount() {
        return attributesCount;
    }

    public void setAttributesCount(short attributesCount) {
        this.attributesCount = attributesCount;
    }

    public byte[] getCode() {
        return code;
    }

    public void setCode(byte[] code) {
        this.code = code;
        Loader loader = new InputStreamLoader(new ByteArrayInputStream(code), new OperationList(code));
        try {
            this.operationList = (OperationList) loader.load();
            for (Operation operation: operationList.getOperations()){
                operation.setConstantPoolList(constantPoolList);
            }
        } catch(FieldReadException fre){
            fre.printStackTrace();
        }
    }

    public OperationList getOperationList() {
        return operationList;
    }

    public int getCodeLength() {
        return codeLength;
    }

    public void setCodeLength(int codeLength) {
        this.codeLength = codeLength;
    }

    public short getExceptionTableLength() {
        return exceptionTableLength;
    }

    public void setExceptionTableLength(short exceptionTableLength) {
        this.exceptionTableLength = exceptionTableLength;
    }

    public List<ExceptionTable> getExceptionTableList() {
        return exceptionTableList;
    }

    public void setExceptionTableList(List<ExceptionTable> exceptionTableList) {
        this.exceptionTableList = exceptionTableList;
    }

    public short getMaxLocals() {
        return maxLocals;
    }

    public void setMaxLocals(short maxLocals) {
        this.maxLocals = maxLocals;
    }

    public short getMaxStack() {
        return maxStack;
    }

    public void setMaxStack(short maxStack) {
        this.maxStack = maxStack;
    }
    
}
