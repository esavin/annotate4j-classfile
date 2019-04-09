package annotate4j.classfile.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Eugene Savin
 */
public class TypeDecoder {

    public static Map<String, String> primitiveTypes = new HashMap<String, String>();

    static {
        primitiveTypes.put("B", "byte");
        primitiveTypes.put("C", "char");
        primitiveTypes.put("D", "double");
        primitiveTypes.put("F", "float");
        primitiveTypes.put("I", "int");
        primitiveTypes.put("J", "long");
        primitiveTypes.put("S", "short");
        primitiveTypes.put("Z", "boolean");
    }

    public String decodeType(String t) {
        if (t == null) {
            return "";
        }
        String s = primitiveTypes.get(t);
        if (s != null) {
            return s;
        }
        if (t.startsWith("L") && t.endsWith(";")) {
            s = t.substring(1, t.length() - 1);
            return decodeObjectType(s);
        }
        if (t.startsWith("[")) {
            return decodeType(t.substring(1)) + "[]";
        }
        return t;
    }

    private String decodeObjectType(String s) {
        String sign = decodeSignature(s);
        if (sign != null && sign.length() > 0) {
            s = s.substring(0, s.indexOf("<")) + sign;
        }
        return s;
    }

    private String decodeSignature(String s) {
        if (s.indexOf("<") > -1) {
            String sign = s.substring(s.indexOf("<") + 1, s.lastIndexOf(">"));
            Iterator<String> iter = new TypeListIterator(sign);
            StringBuffer sb = new StringBuffer();
            while(iter.hasNext()){
                String genericType = iter.next();
                genericType = decodeType(genericType);
                sb.append(genericType).append(", ");
            }
            if (sb.length() > 0){
                sb.setLength(sb.length() - 2);
            }
            return "<" + sb.toString() + ">";
            
        }
        return "";
    }
}
