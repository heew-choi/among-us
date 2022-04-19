package option.printOption;

import employee.Employee;

import java.util.ArrayList;
import java.util.List;

public class CountPrintOption implements IPrintOption {

    @Override
    public String report(List<Employee> employees, String commandName) {
        if (employees.size() == 0)
            return commandName + ",NONE";

        return commandName + "," + employees.size();
    }
}
