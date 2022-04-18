package database;

import employee.Employee;
import exceptions.ImproperlyConfigured;
import option.compareOption.*;
import org.junit.jupiter.api.BeforeEach;
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
    void Select_테스트() {
        assertEquals(3, db.select().size(), "Select 결과 확인");
    }

    @Test
    void 사번_조건_검색_테스트() throws ImproperlyConfigured {
        assertEquals(1, db.select(new EmployeeNumberCompareOption("99887766")).size(), "검색 결과 존재하는 케이스");
        assertEquals(0, db.select(new EmployeeNumberCompareOption("13004450")).size(), "검색 결과 존재하지 않는 케이스");
    }

    @Test
    void 전체_이름_조건_검색_테스트() throws ImproperlyConfigured {
        assertEquals(1, db.select(new NameCompareOption("TESTER CHOI")).size(), "검색 결과 존재하는 케이스");
        assertEquals(0, db.select(new NameCompareOption("TAK DOKGO")).size(), "검색 결과 존재하지 않는 케이스");
    }

    @Test
    void 이름_성_조건_검색_테스트() throws ImproperlyConfigured {
        assertEquals(1, db.select(new LastNameCompareOption("CHOI")).size(), "검색 결과 존재하는 케이스");
        assertEquals(0, db.select(new LastNameCompareOption("DOKGO")).size(), "검색 결과 존재하지 않는 케이스");
    }

    @Test
    void 이름_firstname_조건_검색_테스트() throws ImproperlyConfigured {
        assertEquals(1, db.select(new FirstNameCompareOption("TESTER")).size(), "검색 결과 존재하는 케이스");
        assertEquals(0, db.select(new FirstNameCompareOption("NAMENOTEXIST")).size(), "검색 결과 존재하지 않는 케이스");
    }

    @Test
    void 경력개발단계_조건_검색_테스트() throws ImproperlyConfigured {
        assertEquals(2, db.select(new CareerLevelCompareOption("CL1")).size(), "검색 결과 존재하는 케이스");
        assertEquals(0, db.select(new CareerLevelCompareOption("CL6")).size(), "검색 결과 존재하지 않는 케이스");
    }

    @Test
    void 전화번호_중간자리_검색_테스트() throws ImproperlyConfigured {
        assertEquals(1, db.select(new MiddlePhoneNumberCompareOption("9874")).size(), "검색 결과 존재하는 케이스");
        assertEquals(0, db.select(new MiddlePhoneNumberCompareOption("9898")).size(), "검색 결과 존재하지 않는 케이스");
    }

    @Test
    void 전화번호_끝자리_검색_테스트() throws ImproperlyConfigured {
        assertEquals(1, db.select(new LastPhoneNumberCompareOption("2222")).size(), "검색 결과 존재하는 케이스");
        assertEquals(0, db.select(new LastPhoneNumberCompareOption("4937")).size(), "검색 결과 존재하지 않는 케이스");
    }

    @Test
    void 생일_전체_검색_테스트() throws ImproperlyConfigured {
        assertEquals(1, db.select(new BirthdayCompareOption("19661010")).size(), "검색 결과 존재하는 케이스");
        assertEquals(0, db.select(new BirthdayCompareOption("20221231")).size(), "검색 결과 존재하지 않는 케이스");
    }

    @Test
    void 생일_연도_검색_테스트() throws ImproperlyConfigured {
        assertEquals(1, db.select(new BirthdayYearCompareOption("1966")).size(), "검색 결과 존재하는 케이스");
        assertEquals(0, db.select(new BirthdayYearCompareOption("2022")).size(), "검색 결과 존재하지 않는 케이스");
    }

    @Test
    void 생일_월_검색_테스트() throws ImproperlyConfigured {
        assertEquals(1, db.select(new BirthdayMonthCompareOption("10")).size(), "검색 결과 존재하는 케이스");
        assertEquals(0, db.select(new BirthdayMonthCompareOption("12")).size(), "검색 결과 존재하지 않는 케이스");
    }

    @Test
    void 생일_일_검색_테스트() throws ImproperlyConfigured {
        assertEquals(1, db.select(new BirthdayDayCompareOption("06")).size(), "검색 결과 존재하는 케이스");
        assertEquals(0, db.select(new BirthdayDayCompareOption("31")).size(), "검색 결과 존재하지 않는 케이스");
    }

    @Test
    void CERTI_검색_테스트() throws ImproperlyConfigured {
        assertEquals(1, db.select(new CertificationCompareOption("PRO")).size(), "검색 결과 존재하는 케이스");
        assertEquals(0, db.select(new CertificationCompareOption("IM")).size(), "검색 결과 존재하지 않는 케이스");
    }
}
