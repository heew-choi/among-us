package employee;

import exceptions.ImproperlyConfigured;

public abstract class EmployeeField implements EmployeeFieldValidator {
    protected EmployeeField(String str) throws ImproperlyConfigured {
        if (!isValidString(str))
            throw new ImproperlyConfigured();
    }

    public boolean isValid() {
        return false;
    }

    protected boolean isValidString(String inputString) {
        return false;
    }
}
