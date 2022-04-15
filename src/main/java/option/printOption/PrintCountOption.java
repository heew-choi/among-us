package option.printOption;

import employee.Employee;
import option.printOption.IPrintOption;

import java.util.ArrayList;

public class PrintCountOption implements IPrintOption {

    @Override
    public String report(ArrayList<Employee> employees) {
        if (employees.size() == 0)
            return "NONE";

        return "" + employees.size();
    }
}
