import employee.PhoneNumber;
import exceptions.ImproperlyConfigured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneNumberTest {
    @Test
    void createObjectTest() throws ImproperlyConfigured {
        PhoneNumber phoneNumber = new PhoneNumber("010-2998-6228");
        assertEquals("2998", phoneNumber.getMiddleNumber());
        assertEquals("6228", phoneNumber.getLastNumber());
    }

    @Nested
    @DisplayName("employee.PhoneNumber object validation Check Test")
    class ValidationCheckTest {
        @Test
        @DisplayName("Success case")
        void success() throws ImproperlyConfigured {
            assertTrue(new PhoneNumber("010-2998-6228").isValid());
        }
        @Test
        @DisplayName("Fail case")
        void fail() throws ImproperlyConfigured {
            assertThrows(ImproperlyConfigured.class, () -> new PhoneNumber("010-29a86228"));
            assertThrows(ImproperlyConfigured.class, () -> new PhoneNumber("010-29298-6228"));
            assertThrows(ImproperlyConfigured.class, () -> new PhoneNumber("010-29a8-6228"));
            assertThrows(ImproperlyConfigured.class, () -> new PhoneNumber("010-2929as8-6228"));
        }
    }

}