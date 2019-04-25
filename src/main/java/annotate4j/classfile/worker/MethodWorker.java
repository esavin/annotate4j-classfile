package annotate4j.classfile.worker;

import annotate4j.classfile.structure.ClassFile;
import annotate4j.classfile.structure.LocalVariableTable;
import annotate4j.classfile.structure.Method;
import annotate4j.classfile.structure.attribute.Attribute;
import annotate4j.classfile.structure.attribute.CodeAttribute;
import annotate4j.classfile.structure.attribute.LocalVariableTableAttribute;
import annotate4j.classfile.structure.attribute.SignatureAttribute;
import annotate4j.classfile.structure.constantpool.ClassInfo;
import annotate4j.classfile.structure.constantpool.ConstantPoolItem;
import annotate4j.classfile.structure.constantpool.Utf8Info;
import annotate4j.classfile.utils.TypeDecoder;
import annotate4j.classfile.utils.TypeListIterator;
import annotate4j.core.worker.IdentityMapWorker;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Eugene Savin
 */
public class MethodWorker implements IdentityMapWorker<ClassFile> {

    @Override
    public IdentityHashMap<Object, String> doWork(ClassFile classFile) {
        IdentityHashMap<Object, String> m = new IdentityHashMap<Object, String>();
        List<ConstantPoolItem> cp = classFile.getConstantPoolList();
        List<Method> methods = classFile.getMethodList();
        for (Method method : methods) {
            String accessFlag = decodeAccessFlags(method.getAccessFlags());
            String methodName = getMethodName(cp, method.getNameIndex());
            if (methodName.equals("<init>")) {
                int index = classFile.getThisClassIndex();
                ClassInfo ci = (ClassInfo) cp.get(index - 1);
                Utf8Info u = (Utf8Info) cp.get(ci.getNameIndex() - 1);
                methodName = u.getBytesStr();
                index = methodName.lastIndexOf("/");
                if (index > 0) {
                    methodName = methodName.substring(index + 1);
                }
            }
            short index = method.getDescriptorIndex();
            if (method.getAttributesCount() > 0) {
                for (Attribute atr : method.getAttributeList()) {
                    if (atr instanceof SignatureAttribute) {
                        SignatureAttribute sa = (SignatureAttribute) atr;
                        index = sa.getSignatureIndex();
                        break;
                    }
                }
            }
            String methodType = getMethodType(cp, index);
            if (methodType.equals("V")) {
                methodType = "";
            } else {
                methodType = methodType + " ";
            }
            String params = getMethodParams(cp, index, method);
            m.put(method, accessFlag + " " + methodType + methodName + "(" + params + ")");
        }

        return m;
    }

    private String getMethodParams(List<ConstantPoolItem> cp, short index, Method method) {
        ConstantPoolItem elem = cp.get(index - 1);
        if (elem instanceof Utf8Info) {
            Utf8Info u = (Utf8Info) elem;
            String type = u.getBytesStr();
            type = type.substring(1, type.lastIndexOf(")"));
            type = type.replaceAll("/", ".");
            TypeListIterator iter = new TypeListIterator(type);
            TypeDecoder td = new TypeDecoder();
            StringBuffer sb = new StringBuffer();
            short paramIndex = 1;
            List<Attribute> aList = method.getAttributeList();
            List<LocalVariableTable> lvtList = null;
            for (Attribute a : aList) {
                if (a instanceof CodeAttribute) {
                    CodeAttribute ca = (CodeAttribute) a;
                    List<Attribute> aList1 = ca.getAttributeList();
                    for (Attribute a1 : aList1) {
                        if (a1 instanceof LocalVariableTableAttribute){
                            LocalVariableTableAttribute lvta = (LocalVariableTableAttribute) a1;
                            lvtList = lvta.getLocalVariableTableList();
                        }
                    }
                }
            }
            Map<Short, String> lvtMap = new HashMap<Short, String>();
            if (lvtList != null){
                for (LocalVariableTable lvt: lvtList){
                    String name = ((Utf8Info)cp.get(lvt.getNameIndex() - 1)).getBytesStr();
                    lvtMap.put(lvt.getIndex(), name);
                }
            }
            while (iter.hasNext()) {
                String variableName = lvtMap.get(paramIndex);
                sb.append(td.decodeType(iter.next()));
                if (variableName != null){
                    sb.append(" ").append(variableName);
                }
                sb.append(", ");
                paramIndex++;
            }
            if (sb.length() > 0) {
                sb.setLength(sb.length() - 2);
            }
            return sb.toString();
        }
        return "";
    }

    private String getMethodType(List<ConstantPoolItem> cp, short index) {
        ConstantPoolItem elem = cp.get(index - 1);
        if (elem instanceof Utf8Info) {
            Utf8Info u = (Utf8Info) elem;
            String type = u.getBytesStr();
            type = type.substring(type.lastIndexOf(")") + 1);
            type = type.replaceAll("/", ".");
            TypeDecoder td = new TypeDecoder();
            return td.decodeType(type);
        }
        return "";
    }

    private String getMethodName(List<ConstantPoolItem> cp, short index) {
        ConstantPoolItem elem = cp.get(index - 1);
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

        if ((flag | 0x0020) == flag) {
            sb.append("synchronized ");
        }

        if ((flag | 0x0100) == flag) {
            sb.append("native ");
        }

        if ((flag | 0x0400) == flag) {
            sb.append("abstract ");
        }

        if ((flag | 0x0800) == flag) {
            sb.append("strictfp ");
        }

        if (sb.length() > 1) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }
}
