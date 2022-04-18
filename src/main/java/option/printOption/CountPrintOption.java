package option.printOption;

import employee.Employee;

import java.util.ArrayList;

public class CountPrintOption implements IPrintOption {

    @Override
    public String report(ArrayList<Employee> employees, String commandName) {
        if (employees.size() == 0)
            return "NONE";

        return "" + employees.size();
    }
}