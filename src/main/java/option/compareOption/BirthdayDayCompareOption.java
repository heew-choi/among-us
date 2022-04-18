package option.compareOption;

import employee.Employee;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class BirthdayDayCompareOption extends CompareOption {

    public BirthdayDayCompareOption(String query) {
        super(query);
    }

    @Override
    public ArrayList<Employee> filter(ArrayList<Employee> employees) {
        return employees.stream()
                .filter(employee -> employee.getBirthday().getDay().equals(query))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}