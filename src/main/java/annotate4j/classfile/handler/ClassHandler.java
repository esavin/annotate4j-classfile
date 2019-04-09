package annotate4j.classfile.handler;

import annotate4j.classfile.loader.EntrySizeSupportLoader;
import annotate4j.classfile.worker.PrintMethodSignatureWorker;
import annotate4j.classfile.structure.ClassFile;
import annotate4j.core.DumpBuilder;
import annotate4j.core.Loader;
import annotate4j.core.bin.dump.OutputStreamBuilder;
import annotate4j.core.bin.dump.exceptions.FieldWriteException;
import annotate4j.core.bin.exceptions.FieldReadException;
import annotate4j.core.worker.Worker;

import java.io.*;

/**
 * @author Eugene Savin
 */
public class ClassHandler {
    private Loader loader;


    public void processFile(String inputFileName, String outputFileName) throws IOException, FieldWriteException, FieldReadException {

        FileOutputStream fos = null;

        InputStream is = null;
        ClassFile classFile = null;
        try {
            is = new FileInputStream(inputFileName);
            Loader loader = new EntrySizeSupportLoader(is);

            classFile = (ClassFile) loader.load();
        } finally {
            if (is != null) {
                is.close();
            }
        }

        Worker worker = 
        new PrintMethodSignatureWorker();
        File f = new File(outputFileName);
        classFile = (ClassFile) worker.doWork(classFile);
        try {
            fos = new FileOutputStream(f);
            DumpBuilder dBuilder = new OutputStreamBuilder(fos);
            dBuilder.dump(classFile);
        } finally {
            if (fos != null) {
                fos.flush();
                fos.close();
            }
        }
    }


    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("please specify the input and output file names");
            return;
        }
        ClassHandler classHandler = new ClassHandler();
        try {
            classHandler.processFile(args[0], args[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
