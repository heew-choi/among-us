package option.print;

import employee.Employee;

import java.util.ArrayList;

public class CountPrintOption implements IPrintOption {

    @Override
    public String report(ArrayList<Employee> employees, String commandName) {
        if (employees.isEmpty())
            return commandName + ",NONE";

        return commandName + "," + employees.size();
    }
}
