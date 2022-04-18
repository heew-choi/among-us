package option;

import employee.Employee;
import exceptions.ImproperlyConfigured;
import option.compare.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(DisplayNameGenerator.Standard.ReplaceUnderscores.class)
public class CompareOptionTest {
    Employee employee;

    @BeforeEach
    void setUp() throws ImproperlyConfigured {
        employee = new Employee("15123099", "VXIHXOTH JHOP", "CL3", "010-3112-2609", "19771211", "ADV");
    }

    @Test
    void 기본_비교_옵션_테스트() throws ImproperlyConfigured {
        assertEquals(false, new DefaultCompareOption().compare(employee));
    }

    @Test
    void 사원번호_비교_옵션_테스트() throws ImproperlyConfigured {
        assertEquals(true, new EmployeeNumberCompareOption("15123099").compare(employee));
        assertEquals(false, new EmployeeNumberCompareOption("15123098").compare(employee));
    }

    @Test
    void 성명_비교_옵션_테스트() throws ImproperlyConfigured {
        assertEquals(true, new NameCompareOption("VXIHXOTH JHOP").compare(employee));
        assertEquals(false, new NameCompareOption("VXIHXOTH").compare(employee));
    }

    @Test
    void 성명_이름_비교_옵션_테스트() throws ImproperlyConfigured {
        assertEquals(false, new FirstNameCompareOption("VXIHXOTH JHOP").compare(employee));
        assertEquals(true, new FirstNameCompareOption("VXIHXOTH").compare(employee));
    }

    @Test
    void 성명_성_비교_옵션_테스트() throws ImproperlyConfigured {
        assertEquals(false, new LastNameCompareOption("VXIHXOTH JHOP").compare(employee));
        assertEquals(true, new LastNameCompareOption("JHOP").compare(employee));
    }

    @Test
    void 경력개발단계_비교_옵션_테스트() throws ImproperlyConfigured {
        assertEquals(true, new CareerLevelCompareOption("CL3").compare(employee));
        assertEquals(false, new CareerLevelCompareOption("CL4").compare(employee));
    }

    @Test
    void 전화번호_비교_옵션_테스트() throws ImproperlyConfigured {
        assertEquals(true, new PhoneNumberCompareOption("010-3112-2609").compare(employee));
        assertEquals(false, new PhoneNumberCompareOption("010-3112-2600").compare(employee));
        assertEquals(false, new PhoneNumberCompareOption("3112").compare(employee));
        assertEquals(false, new PhoneNumberCompareOption("2609").compare(employee));
    }

    @Test
    void 전화번호_중간자리_비교_옵션_테스트() throws ImproperlyConfigured {
        assertEquals(false, new MiddlePhoneNumberCompareOption("010-3112-2609").compare(employee));
        assertEquals(false, new MiddlePhoneNumberCompareOption("010-3112-2600").compare(employee));
        assertEquals(true, new MiddlePhoneNumberCompareOption("3112").compare(employee));
        assertEquals(false, new MiddlePhoneNumberCompareOption("2609").compare(employee));
    }

    @Test
    void 전화번호_뒷자리_비교_옵션_테스트() throws ImproperlyConfigured {
        assertEquals(false, new LastPhoneNumberCompareOption("010-3112-2609").compare(employee));
        assertEquals(false, new LastPhoneNumberCompareOption("010-3112-2600").compare(employee));
        assertEquals(false, new LastPhoneNumberCompareOption("3112").compare(employee));
        assertEquals(true, new LastPhoneNumberCompareOption("2609").compare(employee));
    }

    @Test
    void 생년월일_비교_옵션_테스트() throws ImproperlyConfigured {
        assertEquals(true, new BirthdayCompareOption("19771211").compare(employee));
        assertEquals(false, new BirthdayCompareOption("19771210").compare(employee));
        assertEquals(false, new BirthdayCompareOption("1977").compare(employee));
        assertEquals(false, new BirthdayCompareOption("77").compare(employee));
        assertEquals(false, new BirthdayCompareOption("12").compare(employee));
        assertEquals(false, new BirthdayCompareOption("11").compare(employee));
        assertEquals(false, new BirthdayCompareOption("1").compare(employee));
    }

    @Test
    void 생년월일_연도_비교_옵션_테스트() throws ImproperlyConfigured {
        assertEquals(false, new BirthdayYearCompareOption("19771211").compare(employee));
        assertEquals(false, new BirthdayYearCompareOption("19771210").compare(employee));
        assertEquals(true, new BirthdayYearCompareOption("1977").compare(employee));
        assertEquals(false, new BirthdayYearCompareOption("77").compare(employee));
        assertEquals(false, new BirthdayYearCompareOption("12").compare(employee));
        assertEquals(false, new BirthdayYearCompareOption("11").compare(employee));
        assertEquals(false, new BirthdayYearCompareOption("1").compare(employee));
    }

    @Test
    void 생년월일_월_비교_옵션_테스트() throws ImproperlyConfigured {
        assertEquals(false, new BirthdayMonthCompareOption("19771211").compare(employee));
        assertEquals(false, new BirthdayMonthCompareOption("19771210").compare(employee));
        assertEquals(false, new BirthdayMonthCompareOption("1977").compare(employee));
        assertEquals(false, new BirthdayMonthCompareOption("77").compare(employee));
        assertEquals(true, new BirthdayMonthCompareOption("12").compare(employee));
        assertEquals(false, new BirthdayMonthCompareOption("11").compare(employee));
        assertEquals(false, new BirthdayMonthCompareOption("1").compare(employee));
    }

    @Test
    void 생년월일_일_비교_옵션_테스트() throws ImproperlyConfigured {
        assertEquals(false, new BirthdayDayCompareOption("19771211").compare(employee));
        assertEquals(false, new BirthdayDayCompareOption("19771210").compare(employee));
        assertEquals(false, new BirthdayDayCompareOption("1977").compare(employee));
        assertEquals(false, new BirthdayDayCompareOption("77").compare(employee));
        assertEquals(false, new BirthdayDayCompareOption("12").compare(employee));
        assertEquals(true, new BirthdayDayCompareOption("11").compare(employee));
        assertEquals(false, new BirthdayDayCompareOption("1").compare(employee));
    }

    @Test
    void CERTI_비교_옵션_테스트() throws ImproperlyConfigured {
        assertEquals(true, new CertificationCompareOption("ADV").compare(employee));
        assertEquals(false, new CertificationCompareOption("EX").compare(employee));
    }
}
