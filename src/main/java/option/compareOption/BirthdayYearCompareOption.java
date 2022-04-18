package option.compareOption;

import employee.Employee;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class BirthdayYearCompareOption extends CompareOption {

    public BirthdayYearCompareOption(String query) {
        super(query);
    }

    @Override
    public ArrayList<Employee> filter(ArrayList<Employee> employees) {
        return employees.stream()
                .filter(employee -> employee.getBirthday().getYear().equals(query))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}