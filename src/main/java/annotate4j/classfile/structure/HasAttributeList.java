package annotate4j.classfile.structure;

import annotate4j.classfile.structure.attribute.Attribute;

import java.util.List;

/**
 * @author Eugene Savin
 */
public interface HasAttributeList {

    public List<Attribute> getAttributeList();
}
