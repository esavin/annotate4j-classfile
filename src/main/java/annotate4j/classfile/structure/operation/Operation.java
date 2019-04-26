package annotate4j.classfile.structure.operation;

import annotate4j.classfile.structure.constantpool.*;
import annotate4j.core.HasInheritor;
import annotate4j.core.bin.annotation.FieldOrder;
import annotate4j.core.exceptions.InheritorNotFoundException;

import java.util.*;

/**
 * @author Eugene Savin
 * @version Aug 23, 2010
 */


public class Operation implements HasInheritor<Operation> {

    private byte[] code;

    private final static Map<Byte, Class<? extends Operation>> m = new HashMap<Byte, Class<? extends Operation>>();

    static {
        m.put((byte) 0, NopOperation.class);
        m.put((byte) 1, AconstNullOperation.class);
        m.put((byte) 2, IconstM1Operation.class);
        m.put((byte) 3, IconstNOperation.class);
        m.put((byte) 4, IconstNOperation.class);
        m.put((byte) 5, IconstNOperation.class);
        m.put((byte) 6, IconstNOperation.class);
        m.put((byte) 7, IconstNOperation.class);
        m.put((byte) 8, IconstNOperation.class);
        m.put((byte) 9, LconstNOperation.class);
        m.put((byte) 10, LconstNOperation.class);
        m.put((byte) 11, FconstNOperation.class);
        m.put((byte) 12, FconstNOperation.class);
        m.put((byte) 13, FconstNOperation.class);
        m.put((byte) 14, DconstNOperation.class);
        m.put((byte) 15, DconstNOperation.class);
        m.put((byte) 16, BipushOperation.class);
        m.put((byte) 17, SipushOperation.class);
        m.put((byte) 18, LdcOperation.class);
        m.put((byte) 19, LdcWOperation.class);
        m.put((byte) 20, Ldc2WOperation.class);
        m.put((byte) 21, IloadOperation.class);
        m.put((byte) 22, LloadOperation.class);
        m.put((byte) 23, FloadOperation.class);
        m.put((byte) 24, DloadOperation.class);
        m.put((byte) 25, AloadOperation.class);
        m.put((byte) 26, IloadNOperation.class);
        m.put((byte) 27, IloadNOperation.class);
        m.put((byte) 28, IloadNOperation.class);
        m.put((byte) 29, IloadNOperation.class);
        m.put((byte) 30, LloadNOperation.class);
        m.put((byte) 31, LloadNOperation.class);
        m.put((byte) 32, LloadNOperation.class);
        m.put((byte) 33, LloadNOperation.class);
        m.put((byte) 34, FloadNOperation.class);
        m.put((byte) 35, FloadNOperation.class);
        m.put((byte) 36, FloadNOperation.class);
        m.put((byte) 37, FloadNOperation.class);
        m.put((byte) 38, DloadNOperation.class);
        m.put((byte) 39, DloadNOperation.class);
        m.put((byte) 40, DloadNOperation.class);
        m.put((byte) 41, DloadNOperation.class);
        m.put((byte) 42, AloadNOperation.class);
        m.put((byte) 43, AloadNOperation.class);
        m.put((byte) 44, AloadNOperation.class);
        m.put((byte) 45, AloadNOperation.class);
        m.put((byte) 46, IaloadOperation.class);
        m.put((byte) 47, LaloadOperation.class);
        m.put((byte) 48, FaloadOperation.class);
        m.put((byte) 49, DaloadOperation.class);
        m.put((byte) 50, AaloadOperation.class);
        m.put((byte) 51, BaloadOperation.class);
        m.put((byte) 52, CaloadOperation.class);
        m.put((byte) 53, SaloadOperation.class);
        m.put((byte) 54, IstoreOperation.class);
        m.put((byte) 55, LstoreOperation.class);
        m.put((byte) 56, FstoreOperation.class);
        m.put((byte) 57, DstoreOperation.class);
        m.put((byte) 58, AstoreOperation.class);
        m.put((byte) 59, IstoreNOperation.class);
        m.put((byte) 60, IstoreNOperation.class);
        m.put((byte) 61, IstoreNOperation.class);
        m.put((byte) 62, IstoreNOperation.class);
        m.put((byte) 63, LstoreNOperation.class);
        m.put((byte) 64, LstoreNOperation.class);
        m.put((byte) 65, LstoreNOperation.class);
        m.put((byte) 66, LstoreNOperation.class);
        m.put((byte) 67, FstoreNOperation.class);
        m.put((byte) 68, FstoreNOperation.class);
        m.put((byte) 69, FstoreNOperation.class);
        m.put((byte) 70, FstoreNOperation.class);
        m.put((byte) 71, DstoreNOperation.class);
        m.put((byte) 72, DstoreNOperation.class);
        m.put((byte) 73, DstoreNOperation.class);
        m.put((byte) 74, DstoreNOperation.class);
        m.put((byte) 75, AstoreNOperation.class);
        m.put((byte) 76, AstoreNOperation.class);
        m.put((byte) 77, AstoreNOperation.class);
        m.put((byte) 78, AstoreNOperation.class);
        m.put((byte) 79, IastoreOperation.class);
        m.put((byte) 80, LastoreOperation.class);
        m.put((byte) 81, FastoreOperation.class);
        m.put((byte) 82, DastoreOperation.class);
        m.put((byte) 83, AastoreOperation.class);
        m.put((byte) 84, BastoreOperation.class);
        m.put((byte) 85, CastoreOperation.class);
        m.put((byte) 86, SastoreOperation.class);
        m.put((byte) 87, PopOperation.class);
        m.put((byte) 88, Pop2Operation.class);
        m.put((byte) 89, DupOperation.class);
        m.put((byte) 90, DupX1Operation.class);
        m.put((byte) 91, DupX2Operation.class);
        m.put((byte) 92, Dup2Operation.class);
        m.put((byte) 93, Dup2X1Operation.class);
        m.put((byte) 94, Dup2X2Operation.class);
        m.put((byte) 95, SwapOperation.class);
        m.put((byte) 96, IaddOperation.class);
        m.put((byte) 97, LaddOperation.class);
        m.put((byte) 98, FaddOperation.class);
        m.put((byte) 99, DaddOperation.class);
        m.put((byte) 100, IsubOperation.class);
        m.put((byte) 101, LsubOperation.class);
        m.put((byte) 102, FsubOperation.class);
        m.put((byte) 103, DsubOperation.class);
        m.put((byte) 104, ImulOperation.class);
        m.put((byte) 105, LmulOperation.class);
        m.put((byte) 106, FmulOperation.class);
        m.put((byte) 107, DmulOperation.class);
        m.put((byte) 108, IdivOperation.class);
        m.put((byte) 109, LdivOperation.class);
        m.put((byte) 110, FdivOperation.class);
        m.put((byte) 111, DdivOperation.class);
        m.put((byte) 112, IremOperation.class);
        m.put((byte) 113, LremOperation.class);
        m.put((byte) 114, FremOperation.class);
        m.put((byte) 115, DremOperation.class);
        m.put((byte) 116, InegOperation.class);
        m.put((byte) 117, LnegOperation.class);
        m.put((byte) 118, FnegOperation.class);
        m.put((byte) 119, DnegOperation.class);
        m.put((byte) 120, IshlOperation.class);
        m.put((byte) 121, LshlOperation.class);
        m.put((byte) 122, IshrOperation.class);
        m.put((byte) 123, LshrOperation.class);
        m.put((byte) 124, IushrOperation.class);
        m.put((byte) 125, LushrOperation.class);
        m.put((byte) 126, IandOperation.class);
        m.put((byte) 127, LandOperation.class);
        m.put((byte) 128, IorOperation.class);
        m.put((byte) 129, LorOperation.class);
        m.put((byte) 130, IxorOperation.class);
        m.put((byte) 131, LxorOperation.class);
        m.put((byte) 132, IincOperation.class);
        m.put((byte) 133, I2lOperation.class);
        m.put((byte) 134, I2fOperation.class);
        m.put((byte) 135, I2dOperation.class);
        m.put((byte) 136, L2iOperation.class);
        m.put((byte) 137, L2fOperation.class);
        m.put((byte) 138, L2dOperation.class);
        m.put((byte) 139, F2iOperation.class);
        m.put((byte) 140, F2lOperation.class);
        m.put((byte) 141, F2dOperation.class);
        m.put((byte) 142, D2iOperation.class);
        m.put((byte) 143, D2lOperation.class);
        m.put((byte) 144, D2fOperation.class);
        m.put((byte) 145, I2bOperation.class);
        m.put((byte) 146, I2cOperation.class);
        m.put((byte) 147, I2sOperation.class);
        m.put((byte) 148, LcmpOperation.class);
        m.put((byte) 149, FcmplOperation.class);
        m.put((byte) 150, FcmpgOperation.class);
        m.put((byte) 151, DcmplOperation.class);
        m.put((byte) 152, DcmpgOperation.class);
        m.put((byte) 153, IfOperation.class);
        m.put((byte) 154, IfOperation.class);
        m.put((byte) 155, IfOperation.class);
        m.put((byte) 156, IfOperation.class);
        m.put((byte) 157, IfOperation.class);
        m.put((byte) 158, IfOperation.class);
        m.put((byte) 159, IfIcmpOperation.class);
        m.put((byte) 160, IfIcmpOperation.class);
        m.put((byte) 161, IfIcmpOperation.class);
        m.put((byte) 162, IfIcmpOperation.class);
        m.put((byte) 163, IfIcmpOperation.class);
        m.put((byte) 164, IfIcmpOperation.class);
        m.put((byte) 165, IfAcmpOperation.class);
        m.put((byte) 166, IfAcmpOperation.class);
        m.put((byte) 167, GotoOperation.class);
        m.put((byte) 168, JsrOperation.class);
        m.put((byte) 169, RetOperation.class);
        m.put((byte) 170, TableswitchOperation.class);
        m.put((byte) 171, LookupswitchOperation.class);
        m.put((byte) 172, IreturnOperation.class);
        m.put((byte) 173, LreturnOperation.class);
        m.put((byte) 174, FreturnOperation.class);
        m.put((byte) 175, DreturnOperation.class);
        m.put((byte) 176, AreturnOperation.class);
        m.put((byte) 177, ReturnOperation.class);
        m.put((byte) 178, GetstaticOperation.class);
        m.put((byte) 179, PutstaticOperation.class);
        m.put((byte) 180, GetfieldOperation.class);
        m.put((byte) 181, PutfieldOperation.class);
        m.put((byte) 182, InvokevirtualOperation.class);
        m.put((byte) 183, InvokespecialOperation.class);
        m.put((byte) 184, InvokestaticOperation.class);
        m.put((byte) 185, InvokeinterfaceOperation.class);
        m.put((byte) 186, XxxUnusedXxxOperation.class);
        m.put((byte) 187, NewOperation.class);
        m.put((byte) 188, NewarrayOperation.class);
        m.put((byte) 189, AnewarrayOperation.class);
        m.put((byte) 190, ArraylengthOperation.class);
        m.put((byte) 191, AthrowOperation.class);
        m.put((byte) 192, CheckcastOperation.class);
        m.put((byte) 193, InstanceofOperation.class);
        m.put((byte) 194, MonitorenterOperation.class);
        m.put((byte) 195, MonitorexitOperation.class);
        m.put((byte) 196, WideOperation.class);
        m.put((byte) 197, MultianewarrayOperation.class);
        m.put((byte) 198, IfnullOperation.class);
        m.put((byte) 199, IfnonullOperation.class);
        m.put((byte) 200, GotoWOperation.class);
        m.put((byte) 201, JsrWOperation.class);
        m.put((byte) 202, BreakpointOperation.class);
        m.put((byte) 254, Impdep1Operation.class);
        m.put((byte) 255, Impdep2Operation.class);
    }

    private List<ConstantPoolItem> constantPoolList;

    private Stack<Object> stack;

    public Operation() {
    }

    public Operation(List<ConstantPoolItem> cp, Stack<Object> stack) {
        this.constantPoolList = cp;
        this.stack = stack;
    }

    @FieldOrder(index = 1)
    private byte opcode;

    public byte getOpcode() {
        return opcode;
    }

    public void setOpcode(byte opcode) {
        this.opcode = opcode;
    }

    public String getMnemonic() {
        return "";
    }

    public List<ConstantPoolItem> getConstantPoolList() {
        return constantPoolList;
    }

    public void setConstantPoolList(List<ConstantPoolItem> constantPoolList) {
        this.constantPoolList = constantPoolList;
    }

    public Stack<Object> getStack() {
        return stack;
    }

    public void setStack(Stack<Object> stack) {
        this.stack = stack;
    }

    @Override
    public Class<? extends Operation> getInheritor() throws InheritorNotFoundException {
        Class<? extends Operation> clazz = m.get(opcode);
        if (clazz == null) {
            throw new InheritorNotFoundException(this.getClass().getName(), String.valueOf(opcode));
        }
        return clazz;
    }

    @Override
    public Collection<Class<? extends Operation>> getInheritors() {
        return m.values();
    }

    public ConstantPoolItem getConstantPoolEntry(short index) {
        return getConstantPoolList().get(index - 1);
    }

    public String getCommonSignature(short index) {
        CommonRefInfo commonInfo = (CommonRefInfo) getConstantPoolEntry(index);
        NameAndTypeInfo nameAndTypeInfo = (NameAndTypeInfo) getConstantPoolList().get(commonInfo.getNameAndTypeIndex() - 1);

        Utf8Info name = (Utf8Info) getConstantPoolList().get(nameAndTypeInfo.getNameIndex() - 1);
        Utf8Info descritpion = (Utf8Info) getConstantPoolList().get(nameAndTypeInfo.getDescriptorIndex() - 1);
        return name.getBytesStr() + " " + descritpion.getBytesStr();

    }

    public String getClassName(short index) {
        ClassInfo ci = (ClassInfo) getConstantPoolEntry(index);
        Utf8Info u = (Utf8Info) getConstantPoolList().get(ci.getNameIndex() - 1);
        return u.getBytesStr().replaceAll("/", ".");
    }

    public String toString() {
        return  (0x0FF & (int) getOpcode()) + ": " + getMnemonic();
    }

    public byte[] getCode() {
        return code;
    }

    public void setCode(byte[] code) {
        this.code = code;
    }
}
