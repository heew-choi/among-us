public class EmployeeNumber {
    String fullNumber;
    String shortNumber;

    EmployeeNumber(String shortNumber) {
        if (Integer.parseInt(shortNumber.substring(0, 2)) < 68) {
            this.fullNumber = "20"+shortNumber;
        } else {
            this.fullNumber = "19"+shortNumber;
        }
        this.shortNumber = shortNumber;
    }

    public String getFullNumber() {
        return fullNumber;
    }
}
