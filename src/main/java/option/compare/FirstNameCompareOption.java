package option.compare;

import employee.Employee;

public class FirstNameCompareOption extends CompareOption {

    public FirstNameCompareOption(String query) {
        super(query);
    }

    @Override
    public boolean compare(Employee employee) {
        return employee.getName().getFirstName().equals(query);
    }
}
