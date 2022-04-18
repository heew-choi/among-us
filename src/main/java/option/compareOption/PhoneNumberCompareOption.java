package option.compareOption;

import employee.Employee;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class PhoneNumberCompareOption extends CompareOption {

    public PhoneNumberCompareOption(String query) {
        super(query);
    }

    @Override
    public ArrayList<Employee> filter(ArrayList<Employee> employees) {
        return employees.stream()
                .filter(employee -> employee.getPhoneNum().toString().equals(query))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}