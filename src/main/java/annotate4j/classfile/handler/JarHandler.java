package annotate4j.classfile.handler;

import annotate4j.classfile.loader.EntrySizeSupportLoader;
import annotate4j.classfile.structure.ClassFile;
import annotate4j.core.DumpBuilder;
import annotate4j.core.bin.dump.OutputStreamBuilder;
import annotate4j.core.bin.dump.exceptions.FieldWriteException;
import annotate4j.core.bin.exceptions.FieldReadException;
import annotate4j.core.worker.Worker;

import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author Eugene Savin
 */
public class JarHandler {

    private final static int BUFFER_SIZE = 1024;

    List<Worker> workers = new ArrayList<>();


    public void processJar(String inputJar, String outputJar) throws IOException, FieldReadException, FieldWriteException {


        FileOutputStream fos;
        ZipOutputStream zos = null;
        try {
            File cFile = new File(outputJar);
            JarFile f = new JarFile(inputJar);

            Enumeration<JarEntry> entries = f.entries();
            cFile.createNewFile();
            fos = new FileOutputStream(cFile);
            zos = new ZipOutputStream(fos);


            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();
                String name = entry.getName();
                ZipEntry ee = f.getEntry(name);
                ZipEntry newEntry = new ZipEntry(name);
                zos.putNextEntry(newEntry);
                zos.flush();
                String extension = "";
                if (name != null && name.length() > 6) {
                    extension = name.substring(name.length() - 6);
                }
                if (extension.equals(".class")) {

                    EntrySizeSupportLoader loader = new EntrySizeSupportLoader(f.getInputStream(ee));

                    ClassFile classFile = (ClassFile) loader.load();
                    if (workers != null && workers.size() > 0) {
                        for (Worker worker : workers) {
                            classFile = (ClassFile) worker.doWork(classFile);
                        }
                    }

                    DumpBuilder dBuilder = new OutputStreamBuilder(zos);
                    dBuilder.dump(classFile);
                } else if (!newEntry.isDirectory()) {
                    writeContent(f.getInputStream(newEntry), zos);
                }
                zos.flush();
                zos.closeEntry();
            }
            zos.finish();

        } finally {
            if (zos != null) {
                zos.flush();
                zos.close();
            }
        }
    }

    public void addWorker(Worker worker) {
        workers.add(worker);
    }

    public static void main(String[] args) throws Exception {

        if (args.length < 1) {
            System.out.println("Please specify input jar and output dir");
            return;
        }
        JarHandler dumper = new JarHandler();
        try {
            dumper.processJar(args[0],  args[0] + ".res");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeContent(InputStream is, OutputStream os) throws IOException {
        int len;
        byte[] b = new byte[BUFFER_SIZE];
        while ((len = is.read(b)) != -1) {
            os.write(b, 0, len);
        }
    }

}
