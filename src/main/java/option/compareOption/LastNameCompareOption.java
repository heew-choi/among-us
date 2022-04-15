package option.compareOption;

import employee.Employee;
import option.compareOption.CompareOption;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class LastNameCompareOption extends CompareOption {

    LastNameCompareOption(String query) {
        super(query);
    }

    @Override
    public ArrayList<Employee> filter(ArrayList<Employee> employees) {
        return employees.stream()
                .filter(employee -> employee.getName().getLastName().equals(query))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}