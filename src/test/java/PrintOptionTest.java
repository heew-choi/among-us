import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(DisplayNameGenerator.Standard.ReplaceUnderscores.class)
public class PrintOptionTest {

    @Test
    void Print_옵션_테스트() {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee());
        employees.add(new Employee());
        employees.add(new Employee());
        employees.add(new Employee());
        employees.add(new Employee());
        employees.add(new Employee());

        // Print List Test
        PrintListOption printListOption = new PrintListOption();
        assertEquals("", printListOption.Report(employees));

        // Print Count Test
        PrintCountOption printCountOption = new PrintCountOption();
        assertEquals("6", printCountOption.Report(employees));
    }

}
