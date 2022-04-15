package employee;

import exceptions.ImproperlyConfigured;

public class BirthDay extends EmployeeField {
    private String year;
    private String month;
    private String day;

    public BirthDay(String strBirthday) throws ImproperlyConfigured {
        super(strBirthday);
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
}
