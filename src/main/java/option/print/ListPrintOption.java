package option.print;

import employee.Employee;

import java.util.List;
import java.util.stream.Collectors;

public class ListPrintOption implements IPrintOption {

    static final int PRINT_LIMIT = 5;

    @Override
    public String report(List<Employee> employees, String commandName) {
        if (employees.isEmpty())
            return commandName + ",NONE";

        boolean isFirstLine = true;
        StringBuilder result = new StringBuilder();
        for (Employee employee : employees.stream().limit(PRINT_LIMIT).collect(Collectors.toList())) {
            if (!isFirstLine) {
                result.append("\r\n");
            }
            isFirstLine = false;
            result.append(commandName + ',' + employee.toString());
        }
        return result.toString();
    }
}
