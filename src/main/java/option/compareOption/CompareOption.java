package option.compareOption;

import employee.Employee;

import java.util.ArrayList;

public abstract class CompareOption {
    protected String query;

    CompareOption(String query) {
        this.query = query;
    }

    public abstract ArrayList<Employee> filter(ArrayList<Employee> employees);
}
