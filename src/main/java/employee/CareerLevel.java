package employee;

import exceptions.ImproperlyConfigured;

public class CareerLevel extends EmployeeField {
    private String cl;

    public CareerLevel(String cl) throws ImproperlyConfigured {
        super(cl);
        this.cl = cl;
    }

    public String getCl() {
        return cl;
    }

    public void setCl(String cl) {
        this.cl = cl;
    }

    @Override
    public String toString() {
        return this.cl;
    }

    @Override
    public boolean isValid() {
        return isValidString(cl);
    }

    @Override
    public boolean isValidString(String inputString) {
        return inputString.matches("CL[1-4]");
    }
}
