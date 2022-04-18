package option.compareOption;

import employee.Employee;
import option.compareOption.CompareOption;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class LastPhoneNumberCompareOption extends CompareOption {

    public LastPhoneNumberCompareOption(String query) {
        super(query);
    }

    @Override
    public ArrayList<Employee> filter(ArrayList<Employee> employees) {
        return employees.stream()
                .filter(employee -> employee.getPhoneNum().getLastNumber().equals(query))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}