package annotate4j.classfile.utils;

import annotate4j.classfile.structure.constantpool.ClassInfo;
import annotate4j.classfile.structure.constantpool.ConstantPoolItem;
import annotate4j.classfile.structure.constantpool.Utf8Info;

import java.util.List;

public class ConstantPoolUtils {

    public static String getClassNameByIndex(int index, List<ConstantPoolItem> constantPoolList) {
        return getStringByIndex(index, constantPoolList).replaceAll("/", ".");
    }

    public static String getStringByIndex(int index, List<ConstantPoolItem> constantPoolList) {
        ConstantPoolItem item = constantPoolList.get(index - 1);
        if (item instanceof Utf8Info) {
            Utf8Info utf8Info = (Utf8Info) item;
            return utf8Info.getBytesStr();
        } else if (item instanceof ClassInfo) {
            return getStringByIndex(((ClassInfo) item).getNameIndex(), constantPoolList);
        } else {
            throw new RuntimeException("Unexpected constant pool item type: " + item.getClass().getName() + ", exptected value: " + Utf8Info.class.getName());
        }
    }
}
