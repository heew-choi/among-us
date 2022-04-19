package option.print;

import employee.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListPrintOption implements IPrintOption {

    static final int PRINT_LIMIT = 5;

    @Override
    public String report(List<Employee> employees, String commandName) {
        if (employees.isEmpty())
            return commandName + ",NONE";

        ArrayList<String> results = new ArrayList<>();
        for (Employee employee : employees.stream().limit(PRINT_LIMIT).collect(Collectors.toList())) {
            results.add(commandName + ',' + employee.toString());
        }

        return String.join("\r\n", results);
    }
}
