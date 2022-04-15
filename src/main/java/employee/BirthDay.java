package employee;

import exceptions.ImproperlyConfigured;

public class BirthDay extends EmployeeField {
    private String year;
    private String month;
    private String day;

    public BirthDay(String strBirthday) throws ImproperlyConfigured {
        super(strBirthday);
        year = strBirthday.substring(0, 4);
        month = strBirthday.substring(4, 6);
        day = strBirthday.substring(6);
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String toString() {
        return year + month + day;
    }

    @Override
    public boolean isValid() {
        return year.matches("\\d{4}") &&
                month.matches("\\d{2}") &&
                day.matches("\\d{2}") &&
                Integer.parseInt(month) >= 1 &&
                Integer.parseInt(month) <= 12 &&
                Integer.parseInt(day) >= 1 &&
                Integer.parseInt(day) <= 31;
    }

    @Override
    protected boolean isValidString(String inputString) {
        return inputString.matches("\\d{8}");
    }

}
