package option.print;

import employee.Employee;

import java.util.ArrayList;

public interface IPrintOption {
    String report(ArrayList<Employee> employees, String commandName);
}
