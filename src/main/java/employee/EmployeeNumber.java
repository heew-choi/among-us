package employee;

import exceptions.ImproperlyConfigured;

public class EmployeeNumber extends EmployeeField {
    private String fullNumber;
    private String shortNumber;

    public EmployeeNumber(String shortNumber) throws ImproperlyConfigured {
        super(shortNumber);
        this.shortNumber = shortNumber;
        setFullNumber();
    }

    public String getFullNumber() {
        return fullNumber;
    }

    public void setFullNumber() {
        if (Integer.parseInt(shortNumber.substring(0, 2)) > 21)
            this.fullNumber = "19" + shortNumber;
        else
            this.fullNumber = "20" + shortNumber;
    }

    public String getShortNumber() {
        return shortNumber;
    }

    public void setShortNumber(String shortNumber) {
        this.shortNumber = shortNumber;
    }

    @Override
    public boolean isValid() {
        return isValidString(shortNumber);
    }

    @Override
    protected boolean isValidString(String inputString) {
        return inputString.matches("\\d{8}");
    }
}
