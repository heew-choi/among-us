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
    public boolean compare(Employee employee) {
        return employee.getPhoneNum().getLastNumber().equals(query);
    }
}