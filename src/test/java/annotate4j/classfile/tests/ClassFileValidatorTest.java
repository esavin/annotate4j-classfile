package annotate4j.classfile.tests;

import annotate4j.classfile.structure.ClassFile;
import annotate4j.core.validation.Validator;
import annotate4j.core.validation.ValidatorImpl;
import org.testng.annotations.Test;

/**
 * User: eugene
 * Date: 30.10.2010
 */
public class ClassFileValidatorTest {

    @Test
    public void testClassFileStructure() throws Exception {
        Validator v = new ValidatorImpl();
        v.validate(ClassFile.class);
    }
}
