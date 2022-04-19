package option.compare;

import employee.Employee;

public class MiddlePhoneNumberCompareOption extends CompareOption {

    public MiddlePhoneNumberCompareOption(String query) {
        super(query);
    }

    @Override
    public boolean compare(Employee employee) {
        return employee.getPhoneNum().getMiddleNumber().equals(query);
    }
}