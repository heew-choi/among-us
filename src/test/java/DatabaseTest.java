import employee.*;
import exceptions.ImproperlyConfigured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    Database db;
    Employee testEmployee;

    @BeforeEach
    void init() throws ImproperlyConfigured {
        db = new Database();
        testEmployee = new Employee("13004450", "TEST KIM", "CL2", "010-1234-5678", "19901010", "PRO");
        db.insert(new Employee("99887766", "TEST KANG", "CL1", "010-9874-3216", "19661010", "ADV"));
    }

    @Test
    void insertTest() throws ImproperlyConfigured {
        assertEquals(2, db.insert(testEmployee).size(), "Insert 후의 size는 2");
        db.insert(new Employee("07050411", "TEST KING", "CL4", "010-9874-3216", "19801010", "EX"));
        for ( Employee employee : db.select(testEmployee)) {
            System.out.println(employee.getFullEmployeeNumber() + ":" + employee.getCerti());
        }
    }

    @Test
    void selectTest() {
        assertEquals(1, db.select(testEmployee).size(), "Select 결과 확인");
    }

    @Test
    void updateTest() {
        ArrayList<Employee> employees = db.update(0, testEmployee);
        assertEquals("ADV", employees.get(0).getCerti().toString(), "변경 데이터의 certi값");
    }

    @Test
    void deleteTest() {
        ArrayList<Employee> employees = db.delete(0);
        assertEquals(0, employees.size(), "Delete 후의 size는 0");
    }
}
