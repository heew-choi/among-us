package option.compare;

import employee.Employee;

public abstract class CompareOption {
    protected String query;

    protected CompareOption() {
    }

    protected CompareOption(String query) {
        this.query = query;
    }

    public abstract boolean compare(Employee employee);
}
