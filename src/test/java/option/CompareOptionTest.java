package option;

import employee.Employee;
import exceptions.ImproperlyConfigured;
import option.compareOption.BirthdayMonthCompareOption;
import option.compareOption.BirthdayYearCompareOption;
import option.compareOption.CompareOption;
import option.printOption.ListPrintOption;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(DisplayNameGenerator.Standard.ReplaceUnderscores.class)
public class CompareOptionTest {

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
    void 생일_연도_비교_옵션_테스트() throws ImproperlyConfigured {
        // Compare Option Test
        CompareOption compareOption;
        compareOption = new BirthdayYearCompareOption("1977");
        assertEquals("15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV", listPrintOption.report(compareOption.filter(employees)));
    }

    @Test
    void 생일_달_비교_옵션_테스트() throws ImproperlyConfigured {
        // Compare Option Test
        CompareOption compareOption;
        compareOption = new BirthdayMonthCompareOption("12");
        assertEquals("[15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV, 17112609,FB NTAWR,CL4,010-5645-6122,19861203,PRO]", compareOption.filter(employees));
    }
}
