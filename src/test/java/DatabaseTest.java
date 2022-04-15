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
        testEmployee = new Employee(2, new EmployeeNumber("13004450"), new Name(), "CL2", new PhoneNumber(), new BirthDay(), "PRO");
        db.insert(new Employee(1, new EmployeeNumber("99887766"), new Name(), "CL1", new PhoneNumber(), new BirthDay(), "ADV"));
    }

    @Test
    void insertTest() {
        assertEquals(2, db.insert(testEmployee).size(), "Insert 후의 size는 2");
        db.insert(new Employee(99, new EmployeeNumber("07001234"), new Name(), "CL4", new PhoneNumber(), new BirthDay(), "EX"));
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
        assertEquals("ADV", employees.get(0).getCerti(), "변경 데이터의 certi값");
    }

    @Test
    void deleteTest() {
        ArrayList<Employee> employees = db.delete(0);
        assertEquals(0, employees.size(), "Delete 후의 size는 0");
    }
}
