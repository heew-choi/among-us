package command;

import database.Database;
import employee.Employee;
import exceptions.ImproperlyConfigured;
import option.Option;
import option.compare.EmployeeNumberCompareOption;
import option.print.CountPrintOption;
import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DeleteCommandTest {
    DeleteCommand tester;

    @BeforeEach
    void setup() {
        tester = new DeleteCommand(new Database());
    }

    @Test
    @DisplayName("command.Command Type 확인")
    void getCommandType() {
        assertEquals("DEL", tester.getCommandType());
    }

    @Nested
    @DisplayName("command.Command 실행")
    class runTest {

        @Test
        @DisplayName("정상 Case : 삭제")
        void run_normal() {
            tester.getDatabase().insert(new Employee("15123099", "VXIHXOTH JHOP", "CL3", "010-3112-2609", "19771211", "ADV"));
            tester.getDatabase().insert(new Employee("17112609", "FB NTAWR", "CL4", "010-5645-6122", "19861203", "PRO"));

            Option option = new Option(new CountPrintOption(), new EmployeeNumberCompareOption("15123099"));
            tester.setOption(option);
            tester.setParams(Arrays.asList("employeeNum", "15123099"));

            int initCount = tester.getDatabase().select().size();
            tester.run();
            assertEquals(initCount - 1, tester.getDatabase().select().size());
        }

        @Test
        @DisplayName("정상 Case : 삭제 대상 없음")
        void run_normal_duplicated() {
            tester.getDatabase().insert(new Employee("15123099", "VXIHXOTH JHOP", "CL3", "010-3112-2609", "19771211", "ADV"));
            tester.getDatabase().insert(new Employee("17112609", "FB NTAWR", "CL4", "010-5645-6122", "19861203", "PRO"));

            Option option = new Option(new CountPrintOption(), new EmployeeNumberCompareOption("18051268"));
            tester.setOption(option);
            tester.setParams(Arrays.asList("employeeNum", "18051268"));

            int initCount = tester.getDatabase().select().size();
            tester.run();
            assertEquals(initCount, tester.getDatabase().select().size());
        }

    }
}