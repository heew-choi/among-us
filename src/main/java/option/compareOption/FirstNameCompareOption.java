package option.compareOption;

import employee.Employee;
import option.compareOption.CompareOption;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class FirstNameCompareOption extends CompareOption {

    public FirstNameCompareOption(String query) {
        super(query);
    }

    @Override
    public boolean compare(Employee employee) {
        return employee.getName().getFirstName().equals(query);
    }
}
