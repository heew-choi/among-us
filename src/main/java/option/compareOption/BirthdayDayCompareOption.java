package option.compareOption;

import employee.Employee;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class BirthdayDayCompareOption extends CompareOption {

    public BirthdayDayCompareOption(String query) {
        super(query);
    }

    @Override
    public boolean compare(Employee employee) {
        return employee.getBirthday().getDay().equals(query);
    }
}