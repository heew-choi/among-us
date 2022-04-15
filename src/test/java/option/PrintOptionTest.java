package option;

import employee.Employee;
import exceptions.ImproperlyConfigured;
import option.printOption.PrintCountOption;
import option.printOption.PrintListOption;
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
    void Print_카운트_옵션_기본_테스트() {
        // Print Count Test
        PrintCountOption printCountOption = new PrintCountOption();
        assertEquals("6", printCountOption.report(employees));
    }

    @Test
    void Print_리스트_옵션_기본_테스트() {
        // Print List Test
        PrintListOption printListOption = new PrintListOption();
        assertEquals("", printListOption.report(employees));
    }

    @Test
    void Print_카운트_옵션_제로_테스트() {
        // Employee List 준비
        ArrayList<Employee> zeroEmployees = new ArrayList<>();

        // Print Count Test
        PrintCountOption printCountOption = new PrintCountOption();
        assertEquals("NONE", printCountOption.report(zeroEmployees));
    }

    @Test
    void Print_리스트_옵션_제로_테스트() {
        // Employee List 준비
        ArrayList<Employee> zeroEmployees = new ArrayList<>();

        // Print List Test
        PrintListOption printListOption = new PrintListOption();
        assertEquals("NONE", printListOption.report(zeroEmployees));
    }
}
