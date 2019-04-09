# annotate4j-classfile
The Java class byte code description based on annotate4j-core annotations

Note: original code was created in 2009 years and describes all Java 6 specific features. I did not check the modern JVM specifications to reflect new features.

To start learn the Java class bytecode structure just set path to your .class file in the dev.jdigger.classfile.loader.ClassFileLoader class and put breakpoint after the l.load() statement. Walk across the loaded Object and learn the JVM specification, section 4 "The class File Format"