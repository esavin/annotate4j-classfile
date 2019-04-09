package annotate4j.classfile.worker;

import annotate4j.classfile.structure.ClassFile;
import annotate4j.classfile.structure.Method;
import annotate4j.classfile.structure.attribute.Attribute;
import annotate4j.classfile.structure.attribute.CodeAttribute;
import annotate4j.classfile.structure.attribute.SourceFileAttribute;
import annotate4j.classfile.structure.constantpool.ClassInfo;
import annotate4j.classfile.structure.constantpool.ConstantPool;
import annotate4j.classfile.structure.constantpool.Utf8Info;
import annotate4j.core.worker.Worker;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eugene Savin
 */
public class MethodExtractorWorker implements Worker<ClassFile, ClassFile> {
    private List<ConstantPool> ncp = new ArrayList<ConstantPool>();
    private ClassFile nc = new ClassFile();

    @Override
    public ClassFile doWork(ClassFile c) {
        List<ConstantPool> cp = c.getConstantPoolList();


        nc.setMagic(c.getMagic());
        nc.setMinorVersion(c.getMinorVersion());
        nc.setMajorVersion(c.getMajorVersion());
        nc.setAccessFlag(c.getAccessFlag());
        nc.setThisClassIndex((short) (ncp.size() + 1));
        copyClassInfo(cp, c.getThisClassIndex());
        nc.setSuperClassIndex((short) (ncp.size() + 1));
        copyClassInfo(cp, c.getSuperClassIndex());
        nc.setInterfacesCount((short) 0);
        nc.setInterfaceIndexList(new ArrayList());
        nc.setFieldsCount((short) 0);
        nc.setFieldList(new ArrayList());
        nc.setMethodsCount((short) 1);
        Method m = extractMethod(cp, c, 17);
        List<Method> meth = new ArrayList<Method>();
        meth.add(m);
        nc.setMethodList(meth);

        SourceFileAttribute sfa = new SourceFileAttribute();
        sfa.setAttributeLength(2);
        sfa.setAttributeNameIndex((short) (ncp.size() + 1));
        SourceFileAttribute sfa1 = (SourceFileAttribute) c.getAttributeList().get(0); //todo find real index
        copyUtf8Info(cp, sfa1.getAttributeNameIndex());
        sfa.setSourceFileIndex((short) copyUtf8Info(cp, sfa1.getSourceFileIndex()));

        List<Attribute> fattr = new ArrayList<Attribute>();
        fattr.add(sfa);
        nc.setAttributeList(fattr);
        nc.setAttributesCount((short) fattr.size());
        nc.setConstantPoolList(ncp);
        nc.setConstantPoolCount((short) (ncp.size() + 1));
        return nc;
    }

    private Method extractMethod(List<ConstantPool> cp, ClassFile c, int index) {
        Method m = c.getMethodList().get(index);
        Method nm = new Method();
        nm.setAccessFlags(m.getAccessFlags());
        nm.setNameIndex((short) copyUtf8Info(cp, m.getNameIndex()));
        nm.setDescriptorIndex((short) copyUtf8Info(cp, m.getDescriptorIndex()));
        CodeAttribute ca = (CodeAttribute) m.getAttributeList().get(0);
        nm.setAttributesCount((short) 1);
        List<Attribute> aList = new ArrayList<Attribute>();
        CodeAttribute nca = new CodeAttribute();
        nca.setMaxStack(ca.getMaxStack());
        nca.setMaxLocals(ca.getMaxLocals());
        nca.setCodeLength(ca.getCodeLength());
        nca.setCode(ca.getCode());
        //todo
        aList.add(nca);
        nm.setAttributeList(aList);
        return nm;
    }

    private int copyUtf8Info(List<ConstantPool> cp, short index) {
        Utf8Info u = (Utf8Info) cp.get(index - 1);
        ncp.add(u);
        return ncp.size();
    }

    private void copyClassInfo(List<ConstantPool> cp, short index) {
        ClassInfo ci = new ClassInfo();
        ci.setTag((byte) 7);
        ncp.add(ci);
        ci.setNameIndex((short) (ncp.size() + 1));
        ClassInfo ci1 = (ClassInfo) cp.get(index - 1);
        copyUtf8Info(cp, ci1.getNameIndex());
    }
}
