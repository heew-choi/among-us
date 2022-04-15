package employee;

import exceptions.ImproperlyConfigured;

public class EmployeeNumber extends EmployeeField {
    private String fullNumber;
    private String shortNumber;

    public EmployeeNumber(String shortNumber) throws ImproperlyConfigured {
        super(shortNumber);
    public String getFullNumber() {
        return fullNumber;
    }

    public void setFullNumber(String fullNumber) {
        this.fullNumber = fullNumber;
    }

    public String getShortNumber() {
        return shortNumber;
    }

    public void setShortNumber(String shortNumber) {
        this.shortNumber = shortNumber;
    }
    }
}
