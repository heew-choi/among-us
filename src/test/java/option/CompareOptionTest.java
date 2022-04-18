package option;

import employee.Employee;
import exceptions.ImproperlyConfigured;
import option.compareOption.*;
import option.printOption.ListPrintOption;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(DisplayNameGenerator.Standard.ReplaceUnderscores.class)
public class CompareOptionTest {

    String commandName = "SCH";
    ListPrintOption listPrintOption = new ListPrintOption();
    ArrayList<Employee> employees;

    @BeforeEach
    void setUp() throws ImproperlyConfigured {
        // Employee List 준비
        employees = new ArrayList<>();
        employees.add(new Employee("15123099", "VXIHXOTH JHOP", "CL3", "010-3112-2609", "19771211", "ADV"));
        employees.add(new Employee("17112609", "FB NTAWR", "CL4", "010-5645-6122", "19861203", "PRO"));
        employees.add(new Employee("18115040", "TTETHU HBO", "CL3", "010-4581-2050", "20080718", "ADV"));
        employees.add(new Employee("88114052", "NQ LVARW", "CL4", "010-4528-3059", "19500101", "PRO"));
        employees.add(new Employee("19129568", "SRERLALH HMEF", "CL2", "010-3091-9521", "19640910", "PRO"));
        employees.add(new Employee("17111236", "VSID TVO", "CL1", "010-3669-1077", "20120718", "EX"));
    }

    @Test
    void 사원번호_비교_옵션_테스트() throws ImproperlyConfigured {
        CompareOption compareOption;
        compareOption = new EmployeeNumberCompareOption("15123099");
        String expectedResult = "SCH,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV\n";
        assertEquals(expectedResult, listPrintOption.report(compareOption.filter(employees), commandName));
    }

    @Test
    void 성명_비교_옵션_테스트() throws ImproperlyConfigured {
        CompareOption compareOption;
        compareOption = new NameCompareOption("VXIHXOTH JHOP");
        String expectedResult = "SCH,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV\n";
        assertEquals(expectedResult, listPrintOption.report(compareOption.filter(employees), commandName));
    }

    @Test
    void 성명_이름_비교_옵션_테스트() throws ImproperlyConfigured {
        CompareOption compareOption;
        compareOption = new FirstNameCompareOption("VXIHXOTH");
        String expectedResult = "SCH,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV\n";
        assertEquals(expectedResult, listPrintOption.report(compareOption.filter(employees), commandName));
    }

    @Test
    void 성명_성_비교_옵션_테스트() throws ImproperlyConfigured {
        CompareOption compareOption;
        compareOption = new LastNameCompareOption("NTAWR");
        String expectedResult = "SCH,17112609,FB NTAWR,CL4,010-5645-6122,19861203,PRO\n";
        assertEquals(expectedResult, listPrintOption.report(compareOption.filter(employees), commandName));
    }

    @Test
    void 경력개발단계_비교_옵션_테스트() throws ImproperlyConfigured {
        CompareOption compareOption;
        compareOption = new CareerLevelCompareOption("CL4");
        String expectedResult = "SCH,17112609,FB NTAWR,CL4,010-5645-6122,19861203,PRO\n" +
                "SCH,88114052,NQ LVARW,CL4,010-4528-3059,19500101,PRO\n";
        assertEquals(expectedResult, listPrintOption.report(compareOption.filter(employees), commandName));
    }

    @Test
    void 전화번호_비교_옵션_테스트() throws ImproperlyConfigured {
        CompareOption compareOption;
        compareOption = new PhoneNumberCompareOption("010-4528-3059");
        String expectedResult = "SCH,88114052,NQ LVARW,CL4,010-4528-3059,19500101,PRO\n";
        assertEquals(expectedResult, listPrintOption.report(compareOption.filter(employees), commandName));
    }

    @Test
    void 전화번호_중간자리_비교_옵션_테스트() throws ImproperlyConfigured {
        CompareOption compareOption;
        compareOption = new MiddlePhoneNumberCompareOption("4581");
        String expectedResult = "SCH,18115040,TTETHU HBO,CL3,010-4581-2050,20080718,ADV\n";
        assertEquals(expectedResult, listPrintOption.report(compareOption.filter(employees), commandName));
    }

    @Test
    void 전화번호_뒷자리_비교_옵션_테스트() throws ImproperlyConfigured {
        CompareOption compareOption;
        compareOption = new LastPhoneNumberCompareOption("9521");
        String expectedResult = "SCH,19129568,SRERLALH HMEF,CL2,010-3091-9521,19640910,PRO\n";
        assertEquals(expectedResult, listPrintOption.report(compareOption.filter(employees), commandName));
    }

    @Test
    void 생년월일_비교_옵션_테스트() throws ImproperlyConfigured {
        CompareOption compareOption;
        compareOption = new BirthdayCompareOption("20120718");
        String expectedResult = "SCH,17111236,VSID TVO,CL1,010-3669-1077,20120718,EX\n";
        assertEquals(expectedResult, listPrintOption.report(compareOption.filter(employees), commandName));
    }

    @Test
    void 생년월일_연도_비교_옵션_테스트() throws ImproperlyConfigured {
        CompareOption compareOption;
        compareOption = new BirthdayYearCompareOption("1977");
        String expectedResult = "SCH,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV\n";
        assertEquals(expectedResult, listPrintOption.report(compareOption.filter(employees), commandName));
    }

    @Test
    void 생년월일_월_비교_옵션_테스트() throws ImproperlyConfigured {
        CompareOption compareOption;
        compareOption = new BirthdayMonthCompareOption("12");
        String expectedResult = "SCH,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV\n" +
                "SCH,17112609,FB NTAWR,CL4,010-5645-6122,19861203,PRO\n";
        assertEquals(expectedResult, listPrintOption.report(compareOption.filter(employees), commandName));
    }

    @Test
    void 생년월일_일_비교_옵션_테스트() throws ImproperlyConfigured {
        CompareOption compareOption;
        compareOption = new BirthdayDayCompareOption("18");
        String expectedResult = "SCH,18115040,TTETHU HBO,CL3,010-4581-2050,20080718,ADV\n" +
                "SCH,17111236,VSID TVO,CL1,010-3669-1077,20120718,EX\n";
        assertEquals(expectedResult, listPrintOption.report(compareOption.filter(employees), commandName));
    }

    @Test
    void CERTI_비교_옵션_테스트() throws ImproperlyConfigured {
        CompareOption compareOption;
        compareOption = new CertificationCompareOption("EX");
        String expectedResult = "SCH,17111236,VSID TVO,CL1,010-3669-1077,20120718,EX\n";
        assertEquals(expectedResult, listPrintOption.report(compareOption.filter(employees), commandName));
    }
}
