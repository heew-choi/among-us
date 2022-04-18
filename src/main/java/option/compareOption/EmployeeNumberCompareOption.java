package option.compareOption;

import employee.Employee;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class EmployeeNumberCompareOption extends CompareOption {

    public EmployeeNumberCompareOption(String query) {
        super(query);
    }

    @Override
    public boolean compare(Employee employee) {
        return employee.getEmployeeNum().toString().equals(query);
    }
}
