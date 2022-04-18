package option.compareOption;

import employee.Employee;

import java.util.ArrayList;

public abstract class CompareOption {
    protected String query;

    public CompareOption() {
    }

    public CompareOption(String query) {
        this.query = query;
    }

    public abstract boolean compare(Employee employee);
}
