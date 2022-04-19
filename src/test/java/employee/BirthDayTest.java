package employee;

import exceptions.ImproperlyConfigured;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class BirthDayTest {
    static BirthDay b;

    @BeforeAll
    static void setup() {
        b = new BirthDay("19921014");
    }

    @Test
    @DisplayName("getter Test")
    void createInstanceTest() {
        assertEquals("1992", b.getYear() );
        assertEquals("10", b.getMonth());
        assertEquals("14", b.getDay());
    }

    @Test
    @DisplayName("toString() Test")
    void toStringTest() {
        assertEquals("19921014", b.toString());
    }

    @Nested
    class ValidationCheckTest {
        @Test
        @DisplayName("Success case")
        void success() {
            assertTrue(new BirthDay("19921014").isValid());
        }

        @Test
        @DisplayName("Fail case")
        void fail() {
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
