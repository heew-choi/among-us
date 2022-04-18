package option.compareOption;

import employee.Employee;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class PhoneNumberCompareOption extends CompareOption {

    public PhoneNumberCompareOption(String query) {
        super(query);
    }

    @Override
    public boolean compare(Employee employee) {
        return employee.getPhoneNum().toString().equals(query);
    }
}