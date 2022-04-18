package option.printOption;

import employee.Employee;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ListPrintOption implements IPrintOption {

    final int PRINT_LIMIT = 5;

    @Override
    public String report(ArrayList<Employee> employees, String commandName) {
        if (employees.size() == 0)
            return "NONE";

        StringBuffer result = new StringBuffer();
        for (Employee employee : employees.stream().limit(PRINT_LIMIT).collect(Collectors.toList())) {
                result.append(commandName + ',' + employee.toString() + '\n');
        }
        return result.toString();
    }
}
