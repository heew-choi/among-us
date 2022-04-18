package option.compareOption;

import employee.Employee;

public class BirthdayCompareOption extends CompareOption {

    public BirthdayCompareOption(String query) {
        super(query);
    }

    @Override
    public boolean compare(Employee employee) {
        return employee.getBirthday().toString().equals(query);
    }
}