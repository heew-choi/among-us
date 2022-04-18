package option.compareOption;

import employee.Employee;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class CareerLevelCompareOption extends CompareOption {

    public CareerLevelCompareOption(String query) {
        super(query);
    }

    @Override
    public ArrayList<Employee> filter(ArrayList<Employee> employees) {
        return employees.stream()
                .filter(employee -> employee.getCl().toString().equals(query))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
