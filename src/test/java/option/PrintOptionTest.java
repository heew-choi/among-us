package option;

import employee.Employee;
import exceptions.ImproperlyConfigured;
import option.printOption.CountPrintOption;
import option.printOption.ListPrintOption;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(DisplayNameGenerator.Standard.ReplaceUnderscores.class)
public class PrintOptionTest {

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
    void 카운트_프린트_옵션_기본_테스트() {
        CountPrintOption countPrintOption = new CountPrintOption();
        assertEquals("6", countPrintOption.report(employees));
    }

    @Test
    void 리스트_프린트_옵션_기본_테스트() {
        ListPrintOption listPrintOption = new ListPrintOption();
        assertEquals("", listPrintOption.report(employees));
    }

    @Test
    void 카운트_프린트_옵션_제로_테스트() {
        ArrayList<Employee> zeroEmployees = new ArrayList<>();

        CountPrintOption countPrintOption = new CountPrintOption();
        assertEquals("NONE", countPrintOption.report(zeroEmployees));
    }

    @Test
    void 리스트_프린트_옵션_제로_테스트() {
        ArrayList<Employee> zeroEmployees = new ArrayList<>();

        ListPrintOption listPrintOption = new ListPrintOption();
        assertEquals("NONE", listPrintOption.report(zeroEmployees));
    }
}
