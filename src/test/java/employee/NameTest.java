package employee;

import employee.Name;
import exceptions.ImproperlyConfigured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameTest {
    @Test
    void createObjectTest() throws ImproperlyConfigured {
        Name name = new Name("TAEHYUN KIM");
        assertEquals("TAEHYUN", name.getFirstName());
        assertEquals("KIM", name.getLastName());
    }

    @Nested
    @DisplayName("employee.Name object validation Check Test")
    class ValidationCheckTest {
        @Test
        @DisplayName("Success case")
        void success() throws ImproperlyConfigured {
            assertTrue(new Name("KYUMOK KIM").isValid());
        }
        @Test
        @DisplayName("Fail case")
        void fail() {
            assertThrows(ImproperlyConfigured.class, () -> new Name("KYUMOKRRRRRRRRRRRR KIM").isValid());
        }
    }
}
