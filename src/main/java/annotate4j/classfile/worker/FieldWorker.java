package annotate4j.classfile.worker;

import annotate4j.classfile.utils.TypeDecoder;
import annotate4j.classfile.structure.ClassFile;
import annotate4j.classfile.structure.Field;
import annotate4j.classfile.structure.attribute.Attribute;
import annotate4j.classfile.structure.attribute.SignatureAttribute;
import annotate4j.classfile.structure.constantpool.ConstantPool;
import annotate4j.classfile.structure.constantpool.Utf8Info;
import annotate4j.core.worker.IdentityMapWorker;

import java.util.*;

/**
 * @author Eugene Savin
 */
public class FieldWorker implements IdentityMapWorker<ClassFile> {


    @Override
    public IdentityHashMap<Object, String> doWork(ClassFile classFile) {
        IdentityHashMap<Object, String> m = new IdentityHashMap<Object, String>();
        List<ConstantPool> cp = classFile.getConstantPoolList();
        List<Field> fields = classFile.getFieldList();
        for (Field f : fields) {
            String accessFlag = decodeAccessFlags(f.getAccessFlags());
            String fieldName = getFieldName(cp, f.getNameIndex());
            short index = f.getDescriptorIndex();
            if (f.getAttributesCount() > 0) {
                for (Attribute atr : f.getAttributeList()) {
                    if (atr instanceof SignatureAttribute) {
                        SignatureAttribute sa = (SignatureAttribute) atr;
                        index = sa.getSignatureIndex();
                        break;
                    }
                }
            }
            String fieldType = getFieldType(cp, index);
            m.put(f, accessFlag + " " + fieldType + " " + fieldName + ";");
        }

        return m;
    }

    private String getFieldType(List<ConstantPool> cp, short index) {
        ConstantPool elem = cp.get(index - 1);
        if (elem instanceof Utf8Info) {
            Utf8Info u = (Utf8Info) elem;
            String type = u.getBytesStr();
            type = type.replaceAll("/", ".");
            TypeDecoder td = new TypeDecoder();
            return td.decodeType(type);
        }
        return "";
    }


    private String getFieldName(List<ConstantPool> cp, short index) {
        ConstantPool elem = cp.get(index - 1);
        if (elem instanceof Utf8Info) {
            Utf8Info u = (Utf8Info) elem;
            return u.getBytesStr();
        }
        return "";
    }

    private String decodeAccessFlags(short flag) {
        StringBuffer sb = new StringBuffer();
        if ((flag | 0x0001) == flag) {
            sb.append("public ");
        }
        if ((flag | 0x0002) == flag) {
            sb.append("private ");
        }
        if ((flag | 0x0004) == flag) {
            sb.append("protected ");
        }

        if ((flag | 0x0008) == flag) {
            sb.append("static ");
        }

        if ((flag | 0x0010) == flag) {
            sb.append("final ");
        }

        if ((flag | 0x0040) == flag) {
            sb.append("volatile ");
        }

        if ((flag | 0x0080) == flag) {
            sb.append("transient ");
        }

        if (sb.length() > 1) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }
}
