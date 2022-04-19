package option.print;

import employee.Employee;
import java.util.List;

public class CountPrintOption implements IPrintOption {

    @Override
    public String report(List<Employee> employees, String commandName) {
        if (employees.isEmpty())
            return commandName + ",NONE";

        return commandName + "," + employees.size();
    }
}
