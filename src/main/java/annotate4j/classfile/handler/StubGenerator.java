package annotate4j.classfile.handler;

import annotate4j.classfile.worker.CollectMethodsWorker;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Eugene Savin
 */
public class StubGenerator extends JarHandler {

    private final static int BUFFER_SIZE = 1024;


    public static void main(String[] args) throws Exception {


        if (args.length < 3) {
            System.out.println("Please specify input jar, packagePrefix and output dir");
            return;
        }

        String targetFolder = args[2];
        StubGenerator dumper = new StubGenerator();
        CollectMethodsWorker worker = new CollectMethodsWorker(args[1]);

        dumper.addWorker(worker);
        try {
            dumper.processJar(args[0], args[0] + ".res");
        } catch (Exception e) {
            e.printStackTrace();

        }
        Map<String, Set<String>> map = worker.getClasses();
        Set<String> keysToRemove = new HashSet<>();
        Map<String, Set<String>> valuesToAdd = new HashMap<>();
        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            String className = entry.getKey();
            if (className.contains("$")) {
                keysToRemove.add(className);
                Set<String> set = valuesToAdd.computeIfAbsent(className.substring(0, className.lastIndexOf("$")), k -> new HashSet<>());
                String innerClass = getGeneratedClass(entry, className.substring(className.lastIndexOf("$") + 1));

                set.add(innerClass);
            }
        }

        for (String key : keysToRemove) {
            map.remove(key);
        }
        for (Map.Entry<String, Set<String>> entry : valuesToAdd.entrySet()) {
            Set<String> set = map.computeIfAbsent(entry.getKey(), k -> new HashSet<>());
            set.addAll(entry.getValue());
        }

        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            String className = entry.getKey();
            File folder = new File(targetFolder + className.substring(0, className.lastIndexOf("/")));
            folder.mkdir();

            File f = new File(targetFolder + className + ".java");
            try {
                f.createNewFile();
                FileOutputStream fos = null;
                try {
                    fos = new FileOutputStream(f);
                    String packageName = "package " + className.substring(0, className.lastIndexOf("/")).replaceAll("/", ".") + ";\n\n";
                    String content = packageName + getGeneratedClass(entry, className.substring(className.lastIndexOf("/") + 1));
                    if (content.contains("class System")) {
                        content = content.replaceAll("System.out", "java.lang.System.out");
                    }
                    fos.write(content.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (fos != null) {
                        fos.close();
                    }
                }

            } catch (IOException ioe) {
                ioe.printStackTrace();
            }


        }

        System.out.println();
    }

    private static String getGeneratedClass(Map.Entry<String, Set<String>> entry, String className) {
        StringBuilder classBuffer = new StringBuilder();
        classBuffer.append("public class ").append(className).append("{\n");
        for (String item : entry.getValue()) {
            classBuffer.append(item).append("\n");
        }
        classBuffer.append("}");
        String generatedClass = classBuffer.toString();
        if (generatedClass.contains("public abstract ")) {
            generatedClass = generatedClass.replaceAll(" class ", " interface ");
        }
        return generatedClass;
    }

    private void writeContent(InputStream is, OutputStream os) throws IOException {
        int len;
        byte[] b = new byte[BUFFER_SIZE];
        while ((len = is.read(b)) != -1) {
            os.write(b, 0, len);
        }
    }

}
