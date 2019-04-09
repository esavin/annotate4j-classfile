package annotate4j.classfile.utils;


import java.util.Iterator;

/**
 * @author Eugene Savin
 */
public class TypeListIterator implements Iterator<String> {
    private String str;
    private int currentPosition = 0;

    public TypeListIterator(String s) {
        this.str = s;
    }

    @Override
    public boolean hasNext() {
        return currentPosition < str.length();
    }

    @Override
    public String next() {
        int index = findEndOfToken();
        String ret = str.substring(currentPosition, index);
        currentPosition = index;
        return ret;
    }

    private int findEndOfToken() {
        char ch = str.charAt(currentPosition);
        String chS = String.valueOf(ch);
        if (TypeDecoder.primitiveTypes.get(chS) != null) {
            return currentPosition + 1;
        }
        int leftAngleBracketsCount = 0;
        for (int index = currentPosition; index < str.length(); index++) {
            if (str.charAt(index) == '<') {
                leftAngleBracketsCount++;
            }
            if (str.charAt(index) == '>') {
                if (leftAngleBracketsCount > 0) {
                    leftAngleBracketsCount--;
                    if (leftAngleBracketsCount == 0) {
                        return index + 2;
                    }
                }
            }
            if (str.charAt(index) == ';' && leftAngleBracketsCount == 0) {
                return index + 1;
            }
        }
        return str.length();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
