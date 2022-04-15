package employee;

import exceptions.ImproperlyConfigured;

public class Name extends EmployeeField {
    private String firstName;
    private String lastName;

    public Name(String strName) throws ImproperlyConfigured {
        super(strName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
