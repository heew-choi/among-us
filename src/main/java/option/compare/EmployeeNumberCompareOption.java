package option.compare;

import employee.Employee;

public class EmployeeNumberCompareOption extends CompareOption {

    public EmployeeNumberCompareOption(String query) {
        super(query);
    }

    @Override
    public boolean compare(Employee employee) {
        return employee.getEmployeeNum().toString().equals(query);
    }
}
