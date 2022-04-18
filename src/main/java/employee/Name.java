package employee;

import exceptions.ImproperlyConfigured;

public class Name extends EmployeeField {
    private String firstName;
    private String lastName;

    public Name(String strName) throws ImproperlyConfigured {
        super(strName);
        String[] splitName = strName.split(" ");
        firstName = splitName[0];
        lastName = splitName[1];
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

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    @Override
    public boolean isValid() {
        return firstName.matches("[A-Z]+") &&
                lastName.matches("[A-Z]+") &&
                firstName.length() + lastName.length() <= 14;
    }

    @Override
    public boolean isValidString(String inputString) {
        return inputString.length() <= 15 && inputString.matches("[A-Z]+\\s[A-Z]+");
    }
}
