package option.compare;

import employee.Employee;

public class BirthdayYearCompareOption extends CompareOption {

    public BirthdayYearCompareOption(String query) {
        super(query);
    }

    @Override
    public boolean compare(Employee employee) {
        return employee.getBirthday().getYear().equals(query);
    }
}