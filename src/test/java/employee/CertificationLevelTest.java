package employee;

import exceptions.ImproperlyConfigured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CertificationLevelTest {

    @Nested
    @DisplayName("employee.EmployeeNumber validation check test")
    class ValidationCheckTest {
        @Test
        @DisplayName("Success case")
        void success() throws ImproperlyConfigured {
            assertTrue(new CertificationLevel("ADV").isValid());
            assertTrue(new CertificationLevel("PRO").isValid());
            assertTrue(new CertificationLevel("EX").isValid());
        }
        @Test
        @DisplayName("Fail case")
        void fail() {
            assertThrows(ImproperlyConfigured.class, () -> new CertificationLevel("ADVC").isValid());
            assertThrows(ImproperlyConfigured.class, () -> new CertificationLevel("PRO12").isValid());
            assertThrows(ImproperlyConfigured.class, () -> new CertificationLevel("PRO3").isValid());
            assertThrows(ImproperlyConfigured.class, () -> new CertificationLevel("-CKL").isValid());
            assertThrows(ImproperlyConfigured.class, () -> new CertificationLevel("EXP").isValid());
        }
    }

}