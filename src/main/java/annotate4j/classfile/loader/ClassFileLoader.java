package annotate4j.classfile.loader;

import annotate4j.classfile.structure.ClassFile;
import annotate4j.core.Loader;
import annotate4j.core.bin.exceptions.FieldReadException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author Eugene Savin
 */
public class ClassFileLoader implements Loader {
    private Loader loader;

    public ClassFileLoader(String fileName) {
        try {
            File f = new File(fileName);
            FileInputStream fis = new FileInputStream(f);
            loader = new EntrySizeSupportLoader(fis);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object load() throws FieldReadException {
        return loader.load();
    }

    public static void main(String[] args) throws Exception{
        if (args.length == 0){
            System.err.println("Please provide the path to java .class file as parameter");
            System.exit(1);
        }
        ClassFileLoader loader = new ClassFileLoader(args[0]);
        ClassFile loadedClass = (ClassFile) loader.load();



        System.out.println("Class File loaded");
    }
}
