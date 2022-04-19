package option.compare;

import employee.Employee;

public class BirthdayMonthCompareOption extends CompareOption {

    public BirthdayMonthCompareOption(String query) {
        super(query);
    }

    @Override
    public boolean compare(Employee employee) {
        return employee.getBirthday().getMonth().equals(query);
    }
}