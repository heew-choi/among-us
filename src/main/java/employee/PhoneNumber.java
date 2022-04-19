package employee;

public class PhoneNumber extends EmployeeField {
    private String middleNumber;
    private String lastNumber;

    public PhoneNumber(String strPhoneNumber) {
        super(strPhoneNumber);

        String[] splitPhoneNumber = strPhoneNumber.split("-");
        this.middleNumber = splitPhoneNumber[1];
        this.lastNumber = splitPhoneNumber[2];
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

    @Override
    public String toString() {
        return "010-" + middleNumber + "-" + lastNumber;
    }

    @Override
    public boolean isValid() {
        return middleNumber.matches("\\d{4}") &&
                lastNumber.matches("\\d{4}");
    }

    @Override
    public boolean isValidString(String inputString) {
        return inputString.matches("010-\\d{4}-\\d{4}");
    }
}
