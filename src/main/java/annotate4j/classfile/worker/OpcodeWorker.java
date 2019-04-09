package annotate4j.classfile.worker;

import annotate4j.classfile.structure.ClassFile;
import annotate4j.classfile.structure.LineNumberTable;
import annotate4j.classfile.structure.Method;
import annotate4j.classfile.structure.attribute.Attribute;
import annotate4j.classfile.structure.attribute.CodeAttribute;
import annotate4j.classfile.structure.attribute.LineNumberTableAttribute;
import annotate4j.classfile.structure.constantpool.ConstantPool;
import annotate4j.classfile.structure.operation.Operation;
import annotate4j.core.Loader;
import annotate4j.core.bin.exceptions.FieldReadException;
import annotate4j.core.bin.loader.InputStreamLoader;
import annotate4j.core.worker.IdentityMapWorker;

import java.io.ByteArrayInputStream;
import java.util.*;

/**
 * @author Eugene Savin
 */
public class OpcodeWorker implements IdentityMapWorker<ClassFile> {

    @Override
    public IdentityHashMap<Object, String> doWork(ClassFile classFile) {
        IdentityHashMap<Object, String> m = new IdentityHashMap<Object, String>();
        List<ConstantPool> cp = classFile.getConstantPoolList();
        List<Method> methods = classFile.getMethodList();
        for (Method method : methods) {
            List<Attribute> aList = method.getAttributeList();
            for (Attribute a : aList) {
                if (a instanceof CodeAttribute) {
                    CodeAttribute ca = (CodeAttribute) a;
                    byte[] code = ca.getCode();
                    StringBuilder sb = new StringBuilder();
                    sb.append("<html>\n<br>");
                    List<Attribute> caList = ca.getAttributeList();
                    Map<Short, Short> lineNumberMap = new HashMap<Short, Short>();
                    for (Attribute aa : caList) {
                        if (aa instanceof LineNumberTableAttribute) {
                            LineNumberTableAttribute lnta = (LineNumberTableAttribute) aa;
                            List<LineNumberTable> lnt = lnta.getLineNumberTableList();
                            for (LineNumberTable l : lnt) {
                                lineNumberMap.put(l.getStartPc(), l.getLineNumber());
                            }
                        }
                    }
                    short i = 0;
                    ByteArrayInputStream bais = new ByteArrayInputStream(code);
                    Loader loader = new InputStreamLoader(bais, new Operation());
                    List<Operation> operations = new ArrayList<Operation>();
                    Map<Short, Short> operationToCodeOffset = new HashMap<Short, Short>();
                    short otcoi = 0;
                    while (bais.available() > 0) {
                        try {
                            operationToCodeOffset.put(otcoi++, (short)(code.length - bais.available()) );
                            Operation op = (Operation) loader.load();
                            op.setConstantPoolList(cp);
                            operations.add(op);
                        } catch (FieldReadException fre) {
                            fre.printStackTrace();
                        }
                    }
                    for (Operation o : operations) {
                        String prefix =  "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
                        Short lineNumber = lineNumberMap.get(operationToCodeOffset.get(i));
                        if (lineNumber != null) {
                            prefix = "/* " + lineNumber + " */&nbsp;";
                        }
                        sb.append(prefix).append(o.toString()).append("<br>");
                        i++;
                    }
                    sb.append(("\n</html>"));
                    m.put(ca, sb.toString());
                    break;
                }
            }
        }
        return m;
    }


}
