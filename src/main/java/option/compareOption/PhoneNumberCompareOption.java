package option.compareOption;

import employee.Employee;

public class PhoneNumberCompareOption extends CompareOption {

    public PhoneNumberCompareOption(String query) {
        super(query);
    }

    @Override
    public boolean compare(Employee employee) {
        return employee.getPhoneNum().toString().equals(query);
    }
}