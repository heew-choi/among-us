package employee;

import exceptions.ImproperlyConfigured;

public class CertificationLevel extends EmployeeField {
    private String certi;

    protected CertificationLevel(String certi) throws ImproperlyConfigured {
        super(certi);
        this.certi = certi;
    }

    public String getCerti() {
        return certi;
    }

    public void setCerti(String certi) {
        this.certi = certi;
    }

    public String toString() {
        return this.certi;
    }

    @Override
    public boolean isValid() {
        return certi.matches("ADV|PRO|EX");
    }

    @Override
    protected boolean isValidString(String inputString) {
        return inputString.matches("ADV|PRO|EX");
    }
}
