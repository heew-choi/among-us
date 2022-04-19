package option.print;

import employee.Employee;

import java.util.List;

public interface IPrintOption {
    String report(List<Employee> employees, String commandName);
}
