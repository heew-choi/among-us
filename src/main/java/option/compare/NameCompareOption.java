package option.compare;

import employee.Employee;

public class NameCompareOption extends CompareOption {

    public NameCompareOption(String query) {
        super(query);
    }

    @Override
    public boolean compare(Employee employee) {
        return employee.getName().toString().equals(query);
    }
}
