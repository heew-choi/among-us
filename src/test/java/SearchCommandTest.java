import employee.Employee;
import exceptions.ImproperlyConfigured;
import option.Option;
import option.compareOption.EmployeeNumberCompareOption;
import option.printOption.CountPrintOption;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchCommandTest {
    SearchCommand tester;

    @BeforeEach
    void setup() {
        tester = new SearchCommand();
    }

    @Test
    @DisplayName("Command Type 확인")
    void getCommandType() {
        assertEquals("SCH", tester.getCommandType());
    }

    @Nested
    @DisplayName("Command 실행")
    class runTest {

        @Test
        @DisplayName("정상 Case : 검색 성공")
        void run_normal() throws ImproperlyConfigured {
            tester.database.insert(new Employee("15123099", "VXIHXOTH JHOP", "CL3", "010-3112-2609", "19771211", "ADV"));
            tester.database.insert(new Employee("17112609", "FB NTAWR", "CL4", "010-5645-6122", "19861203", "PRO"));

            Option option = new Option(new CountPrintOption(), new EmployeeNumberCompareOption("15123099"));
            tester.setOption(option);

            tester.run();
            assertEquals(1, tester.testResult.size());
        }

        @Test
        @DisplayName("정상 Case : 검색 실패")
        void run_normal_not_fount() throws ImproperlyConfigured {
            tester.database.insert(new Employee("15123099", "VXIHXOTH JHOP", "CL3", "010-3112-2609", "19771211", "ADV"));
            tester.database.insert(new Employee("17112609", "FB NTAWR", "CL4", "010-5645-6122", "19861203", "PRO"));

            Option option = new Option(new CountPrintOption(), new EmployeeNumberCompareOption("18051268"));
            tester.setOption(option);

            tester.run();
            assertEquals(0, tester.testResult.size());
        }

    }
}