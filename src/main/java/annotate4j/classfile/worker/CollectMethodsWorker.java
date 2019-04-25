package annotate4j.classfile.worker;

import annotate4j.classfile.structure.ClassFile;
import annotate4j.classfile.structure.Field;
import annotate4j.classfile.structure.Method;
import annotate4j.classfile.structure.attribute.Attribute;
import annotate4j.classfile.structure.attribute.CodeAttribute;
import annotate4j.classfile.structure.constantpool.*;
import annotate4j.classfile.structure.operation.*;
import annotate4j.classfile.structure.types.Type;
import annotate4j.classfile.structure.types.TypeList;
import annotate4j.classfile.utils.ConstantPoolUtils;
import annotate4j.core.worker.Worker;

import java.util.*;

/**
 * Collects the classes and methods in the interesting packages (defined by pagkagePrefix)
 */

public class CollectMethodsWorker implements Worker<ClassFile, ClassFile> {

    private final String packagePrefix;


    private Map<String, Set<String>> classes = new HashMap<>();

    @Override
    public ClassFile doWork(ClassFile classFile) {

        short thisClassNameIndex = classFile.getThisClassIndex();
        ClassInfo classInfo = (ClassInfo) classFile.getConstantPoolList().get(thisClassNameIndex - 1);
        String thisClassName = ((Utf8Info) classFile.getConstantPoolList().get(classInfo.getNameIndex() - 1)).getBytesStr();
        List<ConstantPoolItem> constantPoolList = classFile.getConstantPoolList();
        for (ConstantPoolItem cp : constantPoolList) {
            if (cp instanceof ClassInfo) {
                String className = ConstantPoolUtils.getStringByIndex(((ClassInfo) cp).getNameIndex(), constantPoolList);
                if (className.startsWith(packagePrefix)) {
                    classes.computeIfAbsent(className, k -> new HashSet<>());
                }
            }

            if (cp instanceof CommonRefInfo) {
                ClassInfo ci = (ClassInfo) constantPoolList.get(((CommonRefInfo) cp).getClassIndex() - 1);
                String className = ConstantPoolUtils.getStringByIndex(ci.getNameIndex(), constantPoolList);
                if (className.startsWith(packagePrefix)) {
                    Set<String> set = classes.computeIfAbsent(className, k -> new HashSet<>());
                    if (cp instanceof FieldRefInfo) {
                        FieldRefInfo field = (FieldRefInfo) cp;
                        String declaredField = generateField(field, classFile.getMethodList());
                        declaredField = replaceToStatic(declaredField, set);
                        set.add(declaredField);
                    }

                    if (cp instanceof MethodRefInfo) {
                        MethodRefInfo method = (MethodRefInfo) cp;
                        String methodImplementation = generateMethod(method, classFile.getMethodList(), ci.getNameIndex(), false, className);
                        methodImplementation = replaceToStatic(methodImplementation, set);
                        set.add(methodImplementation);

                        extractFromMethod(ci, method);
                    }

                    if (cp instanceof InterfaceMethodRefInfo) {
                        InterfaceMethodRefInfo method = (InterfaceMethodRefInfo) cp;
                        String methodImplementation = generateMethod(method, classFile.getMethodList(), ci.getNameIndex(), true, className);
                        methodImplementation = replaceToStatic(methodImplementation, set);
                        set.add(methodImplementation);

                        extractFromMethod(ci, method);
                    }


                }
            }


        }
        return classFile;
    }

    private void extractFromMethod(ClassInfo ci, CommonRefInfo method) {
        Method m = new Method();
        m.setConstantPoolList(method.getConstantPoolList());
        NameAndTypeInfo info = (NameAndTypeInfo) method.getConstantPoolList().get(method.getNameAndTypeIndex() - 1);
        m.setNameIndex(info.getNameIndex());
        m.setDescriptorIndex(info.getDescriptorIndex());
        m.setThisClassIndex(ci.getNameIndex());
        String returnValue = m.getReturnValue().replaceAll("\\.", "/");
        if (returnValue.startsWith(packagePrefix)) {
            classes.computeIfAbsent(returnValue, k -> new HashSet<>());
        }
        TypeList typeList = Method.getTypeList(m.getMethodParams());
        for (Type type : typeList.getTypeList()) {
            returnValue = type.getTypeName().replaceAll("\\.", "/");
            if (returnValue.startsWith(packagePrefix)) {
                classes.computeIfAbsent(returnValue, k -> new HashSet<>());
            }

        }
    }

    private String generateMethod(CommonRefInfo method, List<Method> methods, Short thisClassIndex, boolean callFromInterface, String thisClassName) {
        Method m = new Method();
        m.setConstantPoolList(method.getConstantPoolList());
        NameAndTypeInfo info = (NameAndTypeInfo) method.getConstantPoolList().get(method.getNameAndTypeIndex() - 1);
        m.setNameIndex(info.getNameIndex());
        m.setDescriptorIndex(info.getDescriptorIndex());
        m.setThisClassIndex(thisClassIndex);
        for (Method checkMethod : methods) {
            List<Operation> operations = getOperations(checkMethod);
            for (Operation op : operations) {
                if (op instanceof InvokeinterfaceOperation) {
                    throw new RuntimeException("Invoke Interface Operation not implemented");
                    /*m.setAccessFlags((short)0x0001);
                    return m.toString() + ";";*/
                }
                if (op instanceof InvokevirtualOperation) {
                    m.setAccessFlags((short) 0x0001);

                    return generateMethodContent(m, callFromInterface, thisClassName);
                }

                if (op instanceof InvokespecialOperation) {
                    m.setAccessFlags((short) 0x0001);
                    return generateMethodContent(m, callFromInterface, thisClassName);
                }
                if (op instanceof InvokestaticOperation) {
                    m.setAccessFlags((short) 0x0009);
                    return generateMethodContent(m, callFromInterface, thisClassName);
                }
            }
        }
        throw new RuntimeException("Can not find the understand how the filed used: as static or not static");

    }

    private String generateMethodContent(Method method, boolean callFromInterface, String thisClassName) {
        if (callFromInterface) {
            return method.toString().replaceAll("\\$", ".").replaceAll("public", "public abstract") + ";";
        } else {
            String returnValue = method.getReturnValue();
            if (returnValue.equals("int")) {
                returnValue = "   return 0;\n";
            } else if (returnValue.equals("long")) {
                returnValue = "   return 0;\n";
            } else if (returnValue.contains("[")) {
                returnValue = "   return null;\n";
            } else if (returnValue.equals("java.lang.String")) {
                returnValue = "   return \"return string from " + method.getMethodName() + " method\";\n";
            } else if (returnValue.length() == 0) {
                // we are in constructior nothing to return
            } else if (returnValue.equals("boolean")) {
                returnValue = "   return false;\n";
            } else if (returnValue.startsWith(packagePrefix.replaceAll("/", "."))) {
                returnValue = "   return null;\n";
            } else if (returnValue.equals("void")) {
                // nothing to return if void
                returnValue = "";
            } else if (returnValue.equals("java.lang.Object")) {
                returnValue = "   return null;\n";
            } else if (returnValue.equals("float")) {
                returnValue = "   return 0;\n";
            } else {
                throw new RuntimeException("You need to implement what should be returned if the return type is " + returnValue);
            }
            return method.toString().replaceAll("\\$", ".") + "{\n" +
                    "    System.out.println(\"in the  class " + thisClassName.replaceAll("/", ".")
                    + ", method: " + method.toString() + "  method\");\n " +
                    returnValue +
                    "}";
        }
    }

    private float getField() {
        return 0;
    }


    private String generateField(FieldRefInfo field, List<Method> methods) {
        Field f = new Field();
        f.setConstantPoolList(field.getConstantPoolList());
        NameAndTypeInfo info = (NameAndTypeInfo) field.getConstantPoolList().get(field.getNameAndTypeIndex() - 1);
        f.setNameIndex(info.getNameIndex());
        f.setDescriptorIndex(info.getDescriptorIndex());

        for (Method method : methods) {
            List<Operation> operations = getOperations(method);
            for (Operation op : operations) {
                if (op instanceof GetfieldOperation) {
                    f.setAccessFlags((short) 0x0001);
                    return f.toString();
                }
                if (op instanceof GetstaticOperation) {
                    f.setAccessFlags((short) 0x0009);
                    return f.toString();
                }
            }
        }
        throw new RuntimeException("Can not find the understand how the filed used: as static or not static");

    }

    private String replaceToStatic(String str, Set<String> set) {
        if (str.startsWith("public static ")) {
            String nonStatic = str.replace("public static ", "public ");
            set.remove(nonStatic);
        } else {
            String staticItem = str.replace("public ", "public static ");
            if (set.contains(staticItem)) {
                str = staticItem;
            }
        }
        return str;
    }

    private List<Operation> getOperations(Method method) {
        List<Attribute> attributes = method.getAttributeList();
        for (Attribute a : attributes) {
            if (a instanceof CodeAttribute) {
                return ((CodeAttribute) a).getOperationList().getOperations();
            }
        }
        return Collections.EMPTY_LIST;
    }


    public CollectMethodsWorker(String packagePrefix) {
        this.packagePrefix = packagePrefix;
    }


    public Map<String, Set<String>> getClasses() {
        return classes;
    }


}
