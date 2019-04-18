package annotate4j.classfile.structure.operation;

/**
 * @author Eugene Savin
 * @version Aug 26, 2010
 */
public class ArraylengthOperation extends Operation {

    public ArraylengthOperation() {
        OperationList.setCodePosition(OperationList.getCodePosition() + 3);
    }

    public String getMnemonic() {
        return "arraylength";
    }

}
