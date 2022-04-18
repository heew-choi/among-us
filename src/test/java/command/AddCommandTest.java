package command;

import command.AddCommand;
import database.Database;
import employee.Employee;
import exceptions.ImproperlyConfigured;
import option.Option;
import option.compareOption.DefaultCompareOption;
import option.printOption.CountPrintOption;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddCommandTest {
    AddCommand tester;

    @BeforeEach
    void setup() {
        Option option = new Option(new CountPrintOption(), new DefaultCompareOption());
        tester = new AddCommand(new Database());
        tester.setOption(option);
    }

    @Test
    @DisplayName("command.Command Type 확인")
    void getCommandType() {
        assertEquals("ADD", tester.getCommandType());
    }

    @Nested
    @DisplayName("command.Command 실행")
    class runTest {

        @ParameterizedTest
        @DisplayName("정상 Case : 신규 사원 추가")
        @CsvSource({
                "15123099/VXIHXOTH JHOP/CL3/010-3112-2609/19771211/ADV",
                "17112609/FB NTAWR/CL4/010-5645-6122/19861203/PRO",
                "18115040/TTETHU HBO/CL3/010-4581-2050/20080718/ADV",
                "88114052/NQ LVARW/CL4/010-4528-3059/19911021/PRO",
                "19129568/SRERLALH HMEF/CL2/010-3091-9521/19640910/PRO"
        })
        void run_normal(String paramStr) throws ImproperlyConfigured {
            List<String> params = Arrays.asList(paramStr.split("/"));
            tester.setParams(params);

            int initCount = tester.getDatabase().select().size();
            tester.run();
            assertEquals(initCount + 1, tester.getDatabase().select().size());
        }

        @ParameterizedTest
        @DisplayName("정상 Case : 중복된 사원 미추가")
        @CsvSource({
                "15123099/VXIHXOTH JHOP/CL3/010-3112-2609/19771211/ADV",
                "17112609/FB NTAWR/CL4/010-5645-6122/19861203/PRO"
        })
        void run_normal_duplicated(String paramStr) throws ImproperlyConfigured {
            tester.getDatabase().insert(new Employee("15123099", "VXIHXOTH JHOP", "CL3", "010-3112-2609", "19771211", "ADV"));
            tester.getDatabase().insert(new Employee("17112609", "FB NTAWR", "CL4", "010-5645-6122", "19861203", "PRO"));

            List<String> params = Arrays.asList(paramStr.split("/"));
            tester.setParams(params);

            int initCount = tester.getDatabase().select().size();
            tester.run();
            assertEquals(initCount, tester.getDatabase().select().size());
        }

    }
}