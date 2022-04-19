package option.compare;

import employee.Employee;

public class LastPhoneNumberCompareOption extends CompareOption {

    public LastPhoneNumberCompareOption(String query) {
        super(query);
    }

    @Override
    public boolean compare(Employee employee) {
        return employee.getPhoneNum().getLastNumber().equals(query);
    }
}