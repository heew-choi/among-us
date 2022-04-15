package employee;

import exceptions.ImproperlyConfigured;

public class PhoneNumber extends EmployeeField {
    private String middleNumber;
    private String lastNumber;

    public PhoneNumber(String strPhoneNumber) throws ImproperlyConfigured {
        super(strPhoneNumber);
    }
    public String getMiddleNumber() {
        return middleNumber;
    }

    public void setMiddleNumber(String middleNumber) {
        this.middleNumber = middleNumber;
    }

    public String getLastNumber() {
        return lastNumber;
    }

    public void setLastNumber(String lastNumber) {
        this.lastNumber = lastNumber;
    }
}
