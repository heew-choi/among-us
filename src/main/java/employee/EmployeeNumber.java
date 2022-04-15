package employee;

import exceptions.ImproperlyConfigured;

public class EmployeeNumber extends EmployeeField {
    String fullNumber;
    String shortNumber;

    public EmployeeNumber(String shortNumber) throws ImproperlyConfigured {
        super(shortNumber);
    }
}
