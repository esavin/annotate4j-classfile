package annotate4j.classfile.structure.attribute;

import annotate4j.classfile.structure.constantpool.ConstantPoolItem;
import annotate4j.classfile.structure.constantpool.Utf8Info;
import annotate4j.core.HasInheritor;
import annotate4j.core.bin.annotation.FieldOrder;
import annotate4j.core.exceptions.InheritorNotFoundException;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Eugene Savin
 */
public class Attribute implements HasInheritor<Attribute> {
    private static final Map<String, Class<? extends Attribute>> m = new HashMap<String, Class<? extends Attribute>>();

    static {

        m.put("ConstantValue", ConstantValueAttribute.class);
        m.put("Code", CodeAttribute.class);
        m.put("StackMapTable", StackMapTable.class);
        m.put("Exceptions", ExceptionsAttribute.class);
        m.put("InnerClasses", InnerClassesAttribute.class);
        m.put("EnclosingMethod", EnclosingMethodAttribute.class);
        m.put("Synthetic", SyntheticAttribute.class);
        m.put("Signature", SignatureAttribute.class);
        m.put("SourceFile", SourceFileAttribute.class);
        m.put("SourceDebugExtension", SourceDebugExtensionAttribute.class);
        m.put("LineNumberTable", LineNumberTableAttribute.class);
        m.put("LocalVariableTable", LocalVariableTableAttribute.class);
        m.put("LocalVariableTypeTable", LocalVariableTypeTableAttribute.class);
        m.put("Deprecated", DeprecatedAttribute.class);
        m.put("RuntimeVisibleAnnotations", RuntimeVisibleAnnotationsAttribute.class);
        m.put("RuntimeInvisibleAnnotations", RuntimeInvisibleAnnotationsAttribute.class);
        m.put("RuntimeVisibleParameterAnnotations", RuntimeVisibleParameterAnnotationsAttribute.class);
        m.put("RuntimeInvisibleParameterAnnotations", RuntimeInvisibleParameterAnnotationsAttribute.class);
        m.put("RuntimeVisibleTypeAnnotations", RuntimeVisibleTypeAnnotationsAttribute.class);
        m.put("RuntimeInvisibleTypeAnnotations", RuntimeInvisibleTypeAnnotationsAttribute.class);
        m.put("AnnotationDefault", AnnotationDefaultAttribute.class);
        m.put("BootstrapMethods", BootstrapMethodsAttribute.class);
        m.put("MethodParameters", MethodParametersAttribute.class);
        m.put("Module", ModuleAttribute.class);
        m.put("ModulePackages", ModulePackagesAttribute.class);
        m.put("ModuleMainClass", ModuleMainClassAttribute.class);
        m.put("NestHost", NestHostAttribute.class);
        m.put("NestMembers", NestMembersAttribute.class);
        m.put("Record", RecordAttribute.class);
        m.put("PermittedSubclasses", PermittedSubclassesAttribute.class);
    }

    @FieldOrder(index = 1)
    private short attributeNameIndex;

    @FieldOrder(index = 2)
    private int attributeLength;

    public int getAttributeLength() {
        return attributeLength;
    }

    public void setAttributeLength(int attributeLength) {
        this.attributeLength = attributeLength;
    }

    public short getAttributeNameIndex() {
        return attributeNameIndex;
    }

    public void setAttributeNameIndex(short attributeNameIndex) {
        this.attributeNameIndex = attributeNameIndex;
    }

    protected List<ConstantPoolItem> constantPoolList;



    @Override
    public Class<? extends Attribute> getInheritor() throws InheritorNotFoundException {

        ConstantPoolItem cp = constantPoolList.get(attributeNameIndex - 1);
        if (!(cp instanceof Utf8Info)) {
            throw new InheritorNotFoundException("Provided incorrect index in constantPool: " + attributeNameIndex + " class: " + cp.getClass().getName() +
                    ", the class should be instance of Utf8Info\n" +
                    "constantPoolList: " + constantPoolList.toString());
        }
        Utf8Info info = (Utf8Info) cp;
        byte[] b = info.getBytes();
        String s = new String(b);
        Class<? extends Attribute> c = m.get(s);
        if (c == null) {
            throw new InheritorNotFoundException(this.getClass().getName(), s);
        }
        return c;
    }

    public void setConstantPoolList(List<ConstantPoolItem> constantPoolList) {
        this.constantPoolList = constantPoolList;
    }

    @Override
    public Collection<Class<? extends Attribute>> getInheritors() {
        return m.values();
    }
}
