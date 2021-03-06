package database;

import employee.*;
import exceptions.ImproperlyConfigured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    Database db;
    Employee testEmployee;

    @BeforeEach
    void init() {
        db = new Database();
        testEmployee = new Employee("13004450", "TEST CHOI", "CL2", "010-1234-5678", "19901010", "PRO");
        db.insert(new Employee("99887766", "TEST KANG", "CL1", "010-9874-3216", "19661010", "ADV"));
        db.insert(new Employee("87651234", "TESTER CHOI", "CL3", "010-4344-1121", "19580330", "PRO"));
        db.insert(new Employee("20020202", "TEST HONG", "CL1", "010-2222-2222", "20010406", "ADV"));
    }

    @Test
    void Insert_Test() {
        assertEquals(3, db.select().size(), "Insert 전 Size");
        db.insert(testEmployee);
        assertEquals(4, db.select().size(), "Insert 후 size");
        db.insert(new Employee("07050411", "TEST KING", "CL4", "010-9874-3216", "19801010", "EX"));
        assertEquals("20020202", db.select().get(4).getEmployeeNum().toString(), "데이터의 마지막 사원 정보");
        assertEquals("87651234", db.select().get(0).getEmployeeNum().toString(), "데이터의 첫번째 사원 정보");
        for ( Employee employee : db.select()) {
            System.out.println(employee.getFullEmployeeNumber() + ":" + employee.getName());
        }
    }

    @Test
    void 중복_사번_Insert_테스트() {
        assertEquals(3, db.select().size(), "Insert 전 Size");
        db.insert(new Employee("20020202", "DUPLI KIM", "CL2", "010-1111-2222", "19901221", "EX"));
        assertEquals(3, db.select().size(), "Insert 후 size");
        for ( Employee employee : db.select()) {
            System.out.println(employee.getFullEmployeeNumber() + ":" + employee.getName());
        }
    }

    @Test
    void Update_테스트() {
        Employee targetEmployee = db.select().get(0);
        assertEquals("PRO", targetEmployee.getCerti().toString(), "Update 전 데이터의 certi값");
        System.out.println(targetEmployee.toString());
        Employee changedEmployee = new Employee(targetEmployee.getEmployeeNum().toString(), targetEmployee.getName().toString(), targetEmployee.getCl().toString(),targetEmployee.getPhoneNum().toString(), targetEmployee.getBirthday().toString(), "EX");
        db.update(targetEmployee, changedEmployee);
        assertEquals("EX", targetEmployee.getCerti().toString(), "Update 후 데이터의 certi값");
        System.out.println(targetEmployee.toString());
    }

    @Test
    void Delete_테스트() {
        assertEquals(3, db.select().size(), "Delete 전 size");
        db.delete(db.select().get(0));
        assertEquals(2, db.select().size(), "Delete 후 size");
    }
}
