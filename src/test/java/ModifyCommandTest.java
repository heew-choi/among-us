import database.Database;
import employee.Employee;
import exceptions.ImproperlyConfigured;
import option.Option;
import option.compareOption.*;
import option.printOption.CountPrintOption;
import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ModifyCommandTest {
    ModifyCommand tester;

    @BeforeEach
    void setup() {
        tester = new ModifyCommand(new Database());
    }

    @Test
    @DisplayName("Command Type 확인")
    void getCommandType() {
        assertEquals("MOD", tester.getCommandType());
    }

    @Nested
    @DisplayName("Command 실행")
    class runTest {

        @Test
        @DisplayName("정상 Case : 수정")
        void run_normal() throws ImproperlyConfigured {
            tester.database.insert(new Employee("15123099", "VXIHXOTH JHOP", "CL3", "010-3112-2609", "19771211", "ADV"));
            tester.database.insert(new Employee("17112609", "FB NTAWR", "CL4", "010-5645-6122", "19861203", "PRO"));

            Option option = new Option(new CountPrintOption(), new EmployeeNumberCompareOption("15123099"));
            tester.setOption(option);
            tester.setParams(Arrays.asList("emplyeeNum", "15123099", "name", "MOJI LEE"));
            tester.run();
            assertEquals(1, tester.database.select(new NameCompareOption("MOJI LEE")).size());

            tester.setParams(Arrays.asList("emplyeeNum", "15123099", "cl", "CL2"));
            tester.run();
            assertEquals(1, tester.database.select(new CareerLevelCompareOption("CL2")).size());

            tester.setParams(Arrays.asList("emplyeeNum", "15123099", "phoneNum", "010-5193-1060"));
            tester.run();
            assertEquals(1, tester.database.select(new PhoneNumberCompareOption("010-5193-1060")).size());

            tester.setParams(Arrays.asList("emplyeeNum", "15123099", "birthday", "19921130"));
            tester.run();
            assertEquals(1, tester.database.select(new BirthdayCompareOption("19921130")).size());

            tester.setParams(Arrays.asList("emplyeeNum", "15123099", "certi", "EX"));
            tester.run();
            assertEquals(1, tester.database.select(new CertificationCompareOption("EX")).size());
        }

        @Test
        @DisplayName("정상 Case : 수정 대상 없음")
        void run_normal_duplicated() throws ImproperlyConfigured {
            tester.database.insert(new Employee("15123099", "VXIHXOTH JHOP", "CL3", "010-3112-2609", "19771211", "ADV"));
            tester.database.insert(new Employee("17112609", "FB NTAWR", "CL4", "010-5645-6122", "19861203", "PRO"));

            Option option = new Option(new CountPrintOption(), new EmployeeNumberCompareOption("18051268"));
            tester.setOption(option);
            tester.setParams(Arrays.asList("emplyeeNum", "15123099", "name", "MOJI LEE"));
            tester.run();

            assertEquals(0, tester.database.select(new NameCompareOption("MOJI LEE")).size());
        }

    }
}