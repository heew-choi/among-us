package employee;

import exceptions.ImproperlyConfigured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CareerLevelTest {

    @Nested
    @DisplayName("employee.EmployeeNumber validation check test")
    class ValidationCheckTest {
        @Test
        @DisplayName("Success case")
        void success() throws ImproperlyConfigured {
            assertTrue(new CareerLevel("CL1").isValid());
            assertTrue(new CareerLevel("CL2").isValid());
            assertTrue(new CareerLevel("CL3").isValid());
            assertTrue(new CareerLevel("CL4").isValid());
        }
        @Test
        @DisplayName("Fail case")
        void fail() {
            assertThrows(ImproperlyConfigured.class, () -> new CareerLevel("ADVC").isValid());
            assertThrows(ImproperlyConfigured.class, () -> new CareerLevel("PRO12").isValid());
            assertThrows(ImproperlyConfigured.class, () -> new CareerLevel("PRO3").isValid());
            assertThrows(ImproperlyConfigured.class, () -> new CareerLevel("-CKL").isValid());
            assertThrows(ImproperlyConfigured.class, () -> new CareerLevel("EXP").isValid());
            assertThrows(ImproperlyConfigured.class, () -> new CareerLevel("CL0").isValid());
            assertThrows(ImproperlyConfigured.class, () -> new CareerLevel("CL9").isValid());
            assertThrows(ImproperlyConfigured.class, () -> new CareerLevel("CL5").isValid());
        }
    }

}
