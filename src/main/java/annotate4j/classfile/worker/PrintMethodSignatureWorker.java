package annotate4j.classfile.worker;

import annotate4j.classfile.structure.ClassFile;
import annotate4j.classfile.structure.Method;
import annotate4j.classfile.structure.attribute.Attribute;
import annotate4j.classfile.structure.attribute.ExceptionsAttribute;
import annotate4j.classfile.structure.constantpool.ClassInfo;
import annotate4j.classfile.structure.constantpool.ConstantPool;
import annotate4j.classfile.structure.constantpool.Utf8Info;
import annotate4j.core.worker.Worker;

import java.util.List;

/**
 * @author Eugene Savin
 */
public class PrintMethodSignatureWorker implements Worker<ClassFile, Void> {

    @Override
    public Void doWork(ClassFile classFile) {
        List<Method> methods = classFile.getMethodList();
        List<ConstantPool> cp = classFile.getConstantPoolList();
        int i = 0;
        for (Method m : methods) {
            short nameIndex = m.getNameIndex();
            short descIndex = m.getDescriptorIndex();
            ConstantPool obj = cp.get(nameIndex - 1);
            ConstantPool descObj = cp.get(descIndex - 1);
            if (obj instanceof Utf8Info && descObj instanceof Utf8Info) {
                Utf8Info u = (Utf8Info) obj;
                Utf8Info descriptor = (Utf8Info) descObj;
                StringBuffer sb = new StringBuffer();
                sb.append(i).append(": ").append(resolveAccessFlag(m.getAccessFlags())).
                        append(resolveReturnType(descriptor.getBytesStr())).append(" ")
                        .append(u.getBytesStr()).append(resolveParameters(descriptor.getBytesStr()));
                List<Attribute> mAttr = m.getAttributeList();
                sb.append(" throws ");
                int len = sb.length();
                for (Attribute atr : mAttr) {
                    if (atr instanceof ExceptionsAttribute) {
                        ExceptionsAttribute ea = (ExceptionsAttribute) atr;
                        short[] eIndexs = ea.getExceptionIndexTable();

                        for (int j = 0; j < eIndexs.length; j++) {
                            ConstantPool c = cp.get(eIndexs[j] - 1);
                            if (c instanceof ClassInfo) {
                                ClassInfo ci = (ClassInfo) c;
                                ConstantPool cu = cp.get(ci.getNameIndex() - 1);
                                if (cu instanceof Utf8Info) {
                                    sb.append(((Utf8Info) cu).getBytesStr()).append(", ");
                                }
                            } else {
                                throw new RuntimeException("Expected ClassInfo structure, got " + c.getClass().getName());
                            }

                        }
                    }
                }
                if (sb.length() == len) {
                    sb.setLength(sb.length() - " throws ".length());
                } else {
                    sb.setLength(sb.length() - 2);
                }

                System.out.println(sb.toString().replaceAll("/", ".").replaceAll(";", ""));
            } else {
                throw new RuntimeException("Expected Utf8Info structure, got " + obj.getClass().getName() + ", " + descObj.getClass().getName());
            }
            i++;
        }
        return null;
    }


    private String resolveParameters(String d) {
        String str = d.substring(0, d.lastIndexOf(")") + 1);
        return str;
    }

    private String resolveReturnType(String d) {
        if (d.length() > d.lastIndexOf(")") + 1) {
            String str = d.substring(d.lastIndexOf(")") + 1);
            if (str.equals("V")) {
                return "void";
            }
            if (str.equals("Z")) {
                return "boolean";
            }
            return str;
        }
        return "";
    }

    private String resolveAccessFlag(short flag) {
        StringBuffer sb = new StringBuffer();

        if ((flag | 0x1) == flag) {
            sb.append("public ");
        }
        if ((flag | 0x2) == flag) {
            sb.append("private ");
        }
        if ((flag | 0x4) == flag) {
            sb.append("protected ");
        }
        if ((flag | 0x8) == flag) {
            sb.append("static ");
        }
        if ((flag | 0x10) == flag) {
            sb.append("final ");
        }
        if ((flag | 0x20) == flag) {
            sb.append("synchronized ");
        }
        if ((flag | 0x100) == flag) {
            sb.append("native ");
        }
        if ((flag | 0x400) == flag) {
            sb.append("abstract ");
        }
        if ((flag | 0x800) == flag) {
            sb.append("strictfp ");
        }

        return sb.toString();
    }
}
