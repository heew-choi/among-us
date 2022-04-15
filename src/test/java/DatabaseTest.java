import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    Database db;
    Employee testEmployee;

    @BeforeEach
    void init() {
        db = new Database();
        testEmployee = new Employee(2, new EmployeeNumber(), new Name(), "CL2", new PhoneNumber(), new BirthDay(), "PRO");
        db.insert(new Employee(1, new EmployeeNumber(), new Name(), "CL1", new PhoneNumber(), new BirthDay(), "ADV"));
    }

    @Test
    void insertTest() {
        assertEquals(2, db.insert(testEmployee).size(), "Insert 후의 size는 1");
    }

    @Test
    void selectTest() {
        assertEquals(1, db.select(testEmployee).size(), "Select 결과 확인");
    }

    @Test
    void updateTest() {
        ArrayList<Employee> employees = db.update(1, testEmployee);
        assertEquals("ADV", employees.get(1).getCerti(), "변경 데이터의 certi값");
    }

    @Test
    void deleteTest() {
        ArrayList<Employee> employees = db.delete(1);
        assertEquals(0, employees.size(), "Delete 후의 size는 0");
    }
}
