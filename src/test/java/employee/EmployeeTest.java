package employee;

import employee.Employee;
import exceptions.ImproperlyConfigured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    @Test
    @DisplayName("toString() Test")
    void toStringTest() throws ImproperlyConfigured {
        assertEquals("18050301,KYUMOK KIM,CL2,010-9777-6055,19980906,PRO", new Employee("18050301","KYUMOK KIM","CL2","010-9777-6055","19980906","PRO").toString());
    }

    @Nested
    @DisplayName("employee.Employee object validation Check Test")
    class ValidationCheckTest {
        @Test
        @DisplayName("Success case")
        void success() throws ImproperlyConfigured {
            assertTrue(new Employee("18050301","KYUMOK KIM","CL2","010-9777-6055","19980906","PRO").isValid());
            assertTrue(new Employee("99010504","RKEFMW KIM","CL3","010-1233-5543","19660507","ADV").isValid());
        }
        @Test
        @DisplayName("Fail case")
        void fail() throws ImproperlyConfigured {
            assertThrows(ImproperlyConfigured.class, () -> new Employee("1805001","KYUMOK KIM","CL2","010-9777-6055","19980906","PRO").isValid());
            assertThrows(ImproperlyConfigured.class, () -> new Employee("1805a01","KYUMOK KIM","CL2","010-9777-6055","19980906","PRO").isValid());
            assertThrows(ImproperlyConfigured.class, () -> new Employee("1805a01","KYUMOK ddKIM","CL2","010-9777-6055","19980906","PRO").isValid());
            assertThrows(ImproperlyConfigured.class, () -> new Employee("1805001","KYUMOK FFFFFAAAFKIM","CL2","010-9777-6055","19980906","PRO").isValid());
            assertThrows(ImproperlyConfigured.class, () -> new Employee("1805001","KYUMOK KIM","CL2","010-9777-6055","19980906","PRO").isValid());
            assertThrows(ImproperlyConfigured.class, () -> new Employee("1805001","KYUMOK KIM","CL2","010-9777-6055","19980906","P@RO").isValid());
            assertThrows(ImproperlyConfigured.class, () -> new Employee("1805001","KYUMOK KIM","CL2","010-9777-6055","19980906","EXPERT").isValid());
            assertThrows(ImproperlyConfigured.class, () -> new Employee("1805001","KYUMOK KIM","CL2","010-9777-6055","199w80906","EXP").isValid());
            assertThrows(ImproperlyConfigured.class, () -> new Employee("1805001","KYUMOK KIM","CL5","010-9777-6055","199w80906","EXP").isValid());
        }
    }
}
