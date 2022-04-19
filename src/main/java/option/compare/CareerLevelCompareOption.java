package option.compare;

import employee.Employee;

public class CareerLevelCompareOption extends CompareOption {

    public CareerLevelCompareOption(String query) {
        super(query);
    }

    @Override
    public boolean compare(Employee employee) {
        return employee.getCl().toString().equals(query);
    }
}
