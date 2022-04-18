package option.compareOption;

import employee.Employee;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class BirthdayCompareOption extends CompareOption {

    public BirthdayCompareOption(String query) {
        super(query);
    }

    @Override
    public boolean compare(Employee employee) {
        return employee.getBirthday().toString().equals(query);
    }
}