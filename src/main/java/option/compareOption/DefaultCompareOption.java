package option.compareOption;

import employee.Employee;

public class DefaultCompareOption extends CompareOption {

    public DefaultCompareOption() {
        super();
    }

    @Override
    public boolean compare(Employee employee) {
        return false;
    }
}
