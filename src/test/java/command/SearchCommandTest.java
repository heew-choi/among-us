package command;

import database.Database;
import employee.Employee;
import exceptions.ImproperlyConfigured;
import option.Option;
import option.compare.EmployeeNumberCompareOption;
import option.print.CountPrintOption;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SearchCommandTest {
    SearchCommand tester;

    @BeforeEach
    void setup() {
        tester = new SearchCommand(new Database());
    }

    @Test
    @DisplayName("command.Command Type 확인")
    void getCommandType() {
        assertEquals("SCH", tester.getCommandType());
    }

    @Nested
    @DisplayName("command.Command 실행")
    class runTest {

        @Test
        @DisplayName("정상 Case : 검색 성공")
        void run_normal() {
            tester.getDatabase().insert(new Employee("15123099", "VXIHXOTH JHOP", "CL3", "010-3112-2609", "19771211", "ADV"));
            tester.getDatabase().insert(new Employee("17112609", "FB NTAWR", "CL4", "010-5645-6122", "19861203", "PRO"));

            Option option = new Option(new CountPrintOption(), new EmployeeNumberCompareOption("15123099"));
            tester.setOption(option);
            tester.setParams(Arrays.asList("employeeNum", "15123099"));

            tester.run();
            assertEquals(1, tester.getTestResult().size());
        }

        @Test
        @DisplayName("정상 Case : 검색 실패")
        void run_normal_not_fount() {
            tester.getDatabase().insert(new Employee("15123099", "VXIHXOTH JHOP", "CL3", "010-3112-2609", "19771211", "ADV"));
            tester.getDatabase().insert(new Employee("17112609", "FB NTAWR", "CL4", "010-5645-6122", "19861203", "PRO"));

            Option option = new Option(new CountPrintOption(), new EmployeeNumberCompareOption("18051268"));
            tester.setOption(option);
            tester.setParams(Arrays.asList("employeeNum", "18051268"));

            tester.run();
            assertEquals(0, tester.getTestResult().size());
        }

    }
}