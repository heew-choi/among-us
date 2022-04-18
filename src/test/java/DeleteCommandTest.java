import employee.Employee;
import exceptions.ImproperlyConfigured;
import option.Option;
import option.compareOption.EmployeeNumberCompareOption;
import option.printOption.CountPrintOption;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class DeleteCommandTest {
    DeleteCommand tester;

    @BeforeEach
    void setup() {
        tester = new DeleteCommand();
    }

    @Test
    @DisplayName("Command Type 확인")
    void getCommandType() {
        assertEquals("DEL", tester.getCommandType());
    }

    @Nested
    @DisplayName("Command 실행")
    class runTest {

        @Test
        @DisplayName("정상 Case : 삭제")
        void run_normal() throws ImproperlyConfigured {
            tester.database.insert(new Employee("15123099", "VXIHXOTH JHOP", "CL3", "010-3112-2609", "19771211", "ADV"));
            tester.database.insert(new Employee("17112609", "FB NTAWR", "CL4", "010-5645-6122", "19861203", "PRO"));

            Option option = new Option(new CountPrintOption(), new EmployeeNumberCompareOption("15123099"));
            tester.setOption(option);

            int initCount = tester.database.select().size();
            tester.run();
            assertEquals(initCount - 1, tester.database.select().size());
        }

        @Test
        @DisplayName("정상 Case : 삭제 대상 없음")
        void run_normal_duplicated() throws ImproperlyConfigured {
            tester.database.insert(new Employee("15123099", "VXIHXOTH JHOP", "CL3", "010-3112-2609", "19771211", "ADV"));
            tester.database.insert(new Employee("17112609", "FB NTAWR", "CL4", "010-5645-6122", "19861203", "PRO"));

            Option option = new Option(new CountPrintOption(), new EmployeeNumberCompareOption("18051268"));
            tester.setOption(option);

            int initCount = tester.database.select().size();
            tester.run();
            assertEquals(initCount, tester.database.select().size());
        }

    }
}