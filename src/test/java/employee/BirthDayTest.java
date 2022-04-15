package employee;

import exceptions.ImproperlyConfigured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BirthDayTest {
    @Test
    @DisplayName("Create instance")
    void createInstanceTest() throws ImproperlyConfigured {
        BirthDay b = new BirthDay("19921014");
        assertEquals("1992", b.getYear() );
        assertEquals("10", b.getMonth());
        assertEquals("14", b.getDay());
    }

    @Nested
    class ValidationCheckTest {
        @Test
        @DisplayName("Success case")
        void success() throws ImproperlyConfigured {
            assertTrue(new BirthDay("19921014").isValid());
        }

        @Test
        @DisplayName("Fail case")
        void fail() throws ImproperlyConfigured {
            assertFalse(new BirthDay("19923101").isValid());
            assertFalse(new BirthDay("19921200").isValid());

            assertThrows(ImproperlyConfigured.class, () -> new BirthDay("199210141"));
            assertThrows(ImproperlyConfigured.class, () -> new BirthDay("1992101a"));
            assertThrows(ImproperlyConfigured.class, () -> new BirthDay("1992101ww"));
            assertThrows(ImproperlyConfigured.class, () -> new BirthDay("1992101-"));
            assertThrows(ImproperlyConfigured.class, () -> new BirthDay("\t1992101-"));
            assertThrows(ImproperlyConfigured.class, () -> new BirthDay("1992101-"));
        }

    }
}
