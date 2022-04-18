package option.compareOption;

import employee.Employee;

import java.util.ArrayList;

public class DefaultCompareOption extends CompareOption {

    DefaultCompareOption(String query) {
        super(query);
    }

    @Override
    public ArrayList<Employee> filter(ArrayList<Employee> employees) {
        return new ArrayList<Employee>();
    }
}
