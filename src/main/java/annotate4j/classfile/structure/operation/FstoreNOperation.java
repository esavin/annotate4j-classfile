package annotate4j.classfile.structure.operation;

/**
 * @author Eugene Savin
 * @version Aug 23, 2010
 */
public class FstoreNOperation extends Operation {

    public String getMnemonic() {
        return "fstore_" + (getOpcode() - 67);
    }

}
