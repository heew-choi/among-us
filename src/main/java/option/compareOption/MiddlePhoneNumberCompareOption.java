package option.compareOption;

import employee.Employee;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MiddlePhoneNumberCompareOption extends CompareOption {

    public MiddlePhoneNumberCompareOption(String query) {
        super(query);
    }

    @Override
    public boolean compare(Employee employee) {
        return employee.getPhoneNum().getMiddleNumber().equals(query);
    }
}