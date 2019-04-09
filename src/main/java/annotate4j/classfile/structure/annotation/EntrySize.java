package annotate4j.classfile.structure.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * If annotated element is container entry, this annotation describes that the <code>value</code>
 * of entries will be created in container, the current element will be placed in <code>index</code>
 * entry and others entries will be <code>null</code>
 * <p/>
 * Read JSR-202, The class File Format documentation, section 4.5.5
 *
 * @author Eugene Savin
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface EntrySize {
    /**
     * Size of element entry
     *
     * @return
     */
    int value();

    /**
     * Relative index of annotated entry in container. Note: <code>value</code> shout be greater or
     * equals then <code>index</code>
     *
     * @return
     */
    int index();
}