package annotate4j.classfile.worker;

import annotate4j.classfile.structure.ClassFile;
import annotate4j.classfile.structure.Field;
import annotate4j.classfile.structure.LocalVariableTable;
import annotate4j.classfile.structure.Method;
import annotate4j.classfile.structure.annotation.Annotation;
import annotate4j.classfile.structure.attribute.*;
import annotate4j.classfile.structure.constantpool.*;
import annotate4j.core.worker.Worker;

import java.util.List;

public class RenamePackageWorker implements Worker<ClassFile, ClassFile> {

    private final String replaceFrom;
    private final String replaceTo;

    public RenamePackageWorker(String replaceFrom, String replaceTo) {
        this.replaceFrom = replaceFrom;
        this.replaceTo = replaceTo;
    }

    @Override
    public ClassFile doWork(ClassFile classFile) {
        short thisClassNameIndex = classFile.getThisClassIndex();
        ClassInfo classInfo = (ClassInfo) classFile.getConstantPoolList().get(thisClassNameIndex - 1);
        String thisClassname = ((Utf8Info) classFile.getConstantPoolList().get(classInfo.getNameIndex() - 1)).getBytesStr();
        List<ConstantPoolItem> constantPoolList = classFile.getConstantPoolList();
        for (ConstantPoolItem cp : constantPoolList) {
            if (cp instanceof ClassInfo) {
                replaceInClassInfo(constantPoolList, (ClassInfo) cp);
            }
            if (cp instanceof CommonRefInfo) {
                replaceInMethodsAndFields(constantPoolList, (CommonRefInfo) cp);
            }


        }

        for (Field field : classFile.getFieldList()) {
            for (Attribute attribute : field.getAttributeList()) {
                if (attribute instanceof SignatureAttribute) {
                    SignatureAttribute signatureAttribute = (SignatureAttribute) attribute;
                    replaceByIndex(constantPoolList, signatureAttribute.getSignatureIndex());
                }
            }
        }

        for (Method method : classFile.getMethodList()) {
            replaceByIndex(constantPoolList, method.getDescriptorIndex());

            for (Attribute attribute : method.getAttributeList()) {
                if (attribute instanceof CodeAttribute) {
                    CodeAttribute code = (CodeAttribute) attribute;
                    for (Attribute codeAttribute : code.getAttributeList()) {
                        if (codeAttribute instanceof LocalVariableTableAttribute) {
                            LocalVariableTableAttribute localVariableTableAttribute = (LocalVariableTableAttribute) codeAttribute;
                            List<LocalVariableTable> localVariableTableList = localVariableTableAttribute.getLocalVariableTableList();
                            for (LocalVariableTable localVariableTable : localVariableTableList) {
                                replaceByIndex(constantPoolList, localVariableTable.getDescriptorIndex());
                            }
                        }
                    }
/*
                    // not sure that we should replace it
                    for (Operation operation: code.getOperationList().getOperations()){
                        if (operation instanceof LdcOperation ){
                            LdcOperation ldc = (LdcOperation) operation;
                            ConstantPoolItem cp = constantPoolList.get(ldc.getIndex()-1);
                            if (cp instanceof StringInfo){
                                replaceByIndex(constantPoolList, ((StringInfo)cp).getStringIndex());
                            }

                        }
                    }
*/
                }

                replaceInAttributes(constantPoolList, attribute);

            }
        }

        for (Attribute attribute : classFile.getAttributeList()) {
            replaceInAttributes(constantPoolList, attribute);
        }

        return classFile;
    }

    private void replaceInAttributes(List<ConstantPoolItem> constantPoolList, Attribute attribute) {

        if (attribute instanceof RuntimeVisibleAnnotationsAttribute) {
            RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute = (RuntimeVisibleAnnotationsAttribute) attribute;
            for (Annotation annotation : runtimeVisibleAnnotationsAttribute.getAnnotationList()) {
                replaceByIndex(constantPoolList, annotation.getTypeIndex());
            }
        }

        if (attribute instanceof RuntimeInvisibleAnnotationsAttribute) {
            RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute = (RuntimeInvisibleAnnotationsAttribute) attribute;
            for (Annotation annotation : runtimeInvisibleAnnotationsAttribute.getAnnotationList()) {
                replaceByIndex(constantPoolList, annotation.getTypeIndex());
            }
        }

        if (attribute instanceof SignatureAttribute) {
            SignatureAttribute signatureAttribute = (SignatureAttribute) attribute;
            replaceByIndex(constantPoolList, signatureAttribute.getSignatureIndex());
        }

    }

    private void replaceInMethodsAndFields(List<ConstantPoolItem> constantPoolList, CommonRefInfo cri) {
        short nameAndTypeIndex = cri.getNameAndTypeIndex();
        NameAndTypeInfo nameAndTypeInfo = (NameAndTypeInfo) constantPoolList.get(nameAndTypeIndex - 1);
        replaceByIndex(constantPoolList, nameAndTypeInfo.getDescriptorIndex());
    }

    private void replaceInClassInfo(List<ConstantPoolItem> constantPoolList, ClassInfo ci) {
        replaceByIndex(constantPoolList, ci.getNameIndex());
    }

    private void replaceByIndex(List<ConstantPoolItem> constantPoolList, int index) {
        Utf8Info utf8Info = (Utf8Info) constantPoolList.get(index - 1);
        replaceInUtf8Info(utf8Info);
    }

    private void replaceInUtf8Info(Utf8Info utf8Info) {
        String stringToReplace = utf8Info.getBytesStr();
        if (stringToReplace.contains(replaceFrom)) {
            short originalLenght = (short) stringToReplace.length();
            stringToReplace = stringToReplace.replaceAll(replaceFrom, replaceTo);
            if (originalLenght != stringToReplace.length()) {
                utf8Info.setLength((short) stringToReplace.length());
            }
            utf8Info.setBytes(stringToReplace.getBytes());
        }
    }
}
