package annotate4j.classfile;

import annotate4j.classfile.loader.EntrySizeSupportLoader;
import annotate4j.classfile.structure.ClassFile;
import annotate4j.core.DumpBuilder;
import annotate4j.core.Loader;
import annotate4j.core.StructureDescriptor;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Eugene Savin
 */
public class ClassFileDescriptor implements StructureDescriptor {

    @Override
    public Loader getLoader(InputStream is) {
        return new EntrySizeSupportLoader(is);
    }

    @Override
    public Class getStructureClass() {
        return ClassFile.class;
    }

    @Override
    public String getShortDescription() {
        return "Java .class file structure";
    }

    @Override
    public DumpBuilder getDumpBuilder(OutputStream outputStream) {
        return null;
    }
}
