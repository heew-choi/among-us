package employee;

import exceptions.ImproperlyConfigured;

public abstract class EmployeeField {
    protected EmployeeField(String str) throws ImproperlyConfigured {
        if (!isValidString(str))
            throw new ImproperlyConfigured();
    }

    public String toString() {
        return "";
    }

    public boolean isValid() {
        return false;
    }

    public boolean isValidString(String inputString) {
        return false;
    }
}
