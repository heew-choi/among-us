package option.printOption;

import employee.Employee;

import java.util.ArrayList;
import java.util.List;

public interface IPrintOption {
    String report(List<Employee> employees, String commandName);
}
