package option.compare;

import employee.Employee;

public class LastNameCompareOption extends CompareOption {

    public LastNameCompareOption(String query) {
        super(query);
    }

    @Override
    public boolean compare(Employee employee) {
        return employee.getName().getLastName().equals(query);
    }
}