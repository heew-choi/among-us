import exceptions.ImproperlyConfigured;
import option.Option;
import option.compareOption.DefaultCompareOption;
import option.printOption.CountPrintOption;
import employee.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddCommandTest {
    AddCommand tester;

    @BeforeEach
    void setup() {
        Option option = new Option(new CountPrintOption(), new DefaultCompareOption(""));
        List<String> params = Arrays.asList("15123099", "VXIHXOTH JHOP", "CL3", "010-3112-2609", "19771211","ADV");
        tester = new AddCommand();
        tester.setOption(option);
        tester.setParams(params);
    }

    @Test
    @DisplayName("Command Type 확인")
    void getCommandType() {
        assertEquals("ADD", tester.getCommandType());
    }

    @Nested
    @DisplayName("Command 실행")
    class runTest {

        @Test
        @DisplayName("정상 Case")
        void run_normal() throws ImproperlyConfigured {
            tester.run();

            ArrayList<Employee> expectedList = new ArrayList<>();
            expectedList.add(new Employee("15123099", "VXIHXOTH JHOP", "CL3", "010-3112-2609", "19771211","ADV"));

            assertArrayEquals(expectedList.toArray(), tester.testResult.toArray());
        }
    }
}