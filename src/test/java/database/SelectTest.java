package database;

import employee.Employee;
import exceptions.ImproperlyConfigured;
import option.compareOption.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SelectTest {
    Database db;
    Employee testEmployee;

    @BeforeEach
    void init() throws ImproperlyConfigured {
        db = new Database();
        testEmployee = new Employee("13004450", "TEST CHOI", "CL2", "010-1234-5678", "19901010", "PRO");
        db.insert(new Employee("99887766", "TEST KANG", "CL1", "010-9874-3216", "19661010", "ADV"));
        db.insert(new Employee("87651234", "TESTER CHOI", "CL3", "010-4344-1121", "19580330", "PRO"));
        db.insert(new Employee("20020202", "TEST HONG", "CL1", "010-2222-2222", "20010406", "ADV"));
    }

    @Test
    @DisplayName("Select 테스트")
    void selectTest() {
        assertEquals(3, db.select().size(), "Select 결과 확인");
    }

    @Test
    @DisplayName("이름(성) 조건 검색 테스트")
    void lastNameConditionSelectTest() throws ImproperlyConfigured {
        assertEquals(1, db.select(new LastNameCompareOption("CHOI")).size(), "Select 결과 확인");
    }

    @Test
    @DisplayName("이름 조건 검색 테스트")
    void firstNameConditionSelectTest() throws ImproperlyConfigured {
        assertEquals(1, db.select(new FirstNameCompareOption("TESTER")).size(), "Select 결과 확인");
    }

    @Test
    @DisplayName("전화번호 중간자리 검색 테스트")
    void middlePhoneNumberSelectTest() throws ImproperlyConfigured {
        assertEquals(1, db.select(new MiddlePhoneNumberCompareOption("9874")).size(), "전화번호 중간자리 검색 결과 확인");
    }

    @Test
    @DisplayName("전화번호 끝자리 검색 테스트")
    void lastPhoneNumberSelectTest() throws ImproperlyConfigured {
        assertEquals(1, db.select(new LastPhoneNumberCompareOption("2222")).size(), "전화번호 끝자리 검색 결과 확인");
    }
}
