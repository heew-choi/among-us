package option.compareOption;

import employee.Employee;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class DefaultCompareOption extends CompareOption {

    public DefaultCompareOption() {
        super();
    }

    @Override
    public boolean compare(Employee employee) {
        return true;
    }
}
