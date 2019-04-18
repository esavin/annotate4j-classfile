package annotate4j.classfile.structure.operation;

/**
 * @author Eugene Savin
 * @version Aug 26, 2010
 */
public class LookupswitchOperation extends Operation {



    public LookupswitchOperation() {
        // TODO increment opcode counter
        throw new RuntimeException("Not implemented");
    }

    public String getMnemonic() {
        return "lookupswitch";
    }

}
