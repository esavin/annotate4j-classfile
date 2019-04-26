package annotate4j.classfile.structure.types;

import annotate4j.core.HasInheritor;
import annotate4j.core.bin.annotation.ContainerSize;
import annotate4j.core.bin.annotation.FieldOrder;
import annotate4j.core.exceptions.InheritorNotFoundException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Type implements HasInheritor<Type> {

    private final static Map<String, Class<? extends Type>> m = new HashMap<String, Class<? extends Type>>();

    static {
        m.put("[", ArrayType.class);
        m.put("Z", BooleanType.class);
        m.put("B", ByteType.class);
        m.put("C", CharType.class);
        m.put("L", ClassType.class);
        m.put("D", DoubleType.class);
        m.put("F", FloatType.class);
        m.put("I", IntType.class);
        m.put("J", LongType.class);
        m.put("S", ShortType.class);

    }

    @FieldOrder(index = 1)
    @ContainerSize(value = 1)
    private String typeDescritor;

    @Override
    public Class<? extends Type> getInheritor() throws InheritorNotFoundException {
        Class<? extends Type> clazz = m.get(typeDescritor);
        if (clazz == null) {
            throw new InheritorNotFoundException(this.getClass().getName(), typeDescritor);
        }
        return clazz;
    }

    @Override
    public Collection<Class<? extends Type>> getInheritors() {
        return m.values();
    }

    public String getTypeDescritor() {
        return typeDescritor;
    }

    public void setTypeDescritor(String typeDescritor) {
        this.typeDescritor = typeDescritor;
    }

    public String getTypeName(){
        return "Type not defined";
    }
}
