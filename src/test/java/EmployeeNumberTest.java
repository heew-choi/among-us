import employee.EmployeeNumber;
import exceptions.ImproperlyConfigured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeNumberTest {

    @Nested
    @DisplayName("employee.EmployeeNumber validation check test")
    class ValidationCheckTest {
        @Test
        @DisplayName("Success case")
        void success() throws ImproperlyConfigured {
            assertTrue(new EmployeeNumber("18020989").isValid());
        }
        @Test
        @DisplayName("Fail case")
        void fail() throws ImproperlyConfigured {
            assertFalse(new EmployeeNumber("118020989").isValid());
            assertFalse(new EmployeeNumber("80209a").isValid());
            assertFalse(new EmployeeNumber("-1a209a").isValid());
        }
    }
}
