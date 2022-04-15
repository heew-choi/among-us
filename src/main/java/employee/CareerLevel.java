package employee;

import exceptions.ImproperlyConfigured;

public class CareerLevel extends EmployeeField {
    private String cl;

    protected CareerLevel(String cl) throws ImproperlyConfigured {
        super(cl);
        this.cl = cl;
    }

    public String getCl() {
        return cl;
    }

    public void setCl(String cl) {
        this.cl = cl;
    }

    public String toString() {
        return this.cl;
    }

    @Override
    public boolean isValid() {
        return cl.matches("CL[1-4]");
    }

    @Override
    protected boolean isValidString(String inputString) {
        return inputString.matches("CL[1-4]");
    }
}
