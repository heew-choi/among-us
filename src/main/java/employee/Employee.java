package employee;

import exceptions.ImproperlyConfigured;

public class Employee {
    private int id;
    private EmployeeNumber employeeNum;
    private Name name;
    private String cl;
    private PhoneNumber phoneNum;
    private BirthDay birthday;
    private String certi;

    public Employee() {

    }

    public Employee(String strEmployeeNum, String strName, String cl, String strPhoneNumber, String strBirthday, String certi) throws ImproperlyConfigured {
        this.employeeNum = new EmployeeNumber(strEmployeeNum);
        this.name = new Name(strName);
        this.cl = cl;
        this.phoneNum = new PhoneNumber(strPhoneNumber);
        this.birthday = new BirthDay(strBirthday);
        this.certi = certi;
    }

    public boolean isValid() {
        return employeeNum.isValid() &&
                name.isValid() &&
                phoneNum.isValid() &&
                birthday.isValid() &&
                cl.matches("CL[1-4]") &&
                certi.matches("ADV|PRO|EX");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EmployeeNumber getEmployeeNum() {
        return employeeNum;
    }

    public void setEmployeeNum(EmployeeNumber employeeNum) {
        this.employeeNum = employeeNum;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getCl() {
        return cl;
    }

    public void setCl(String cl) {
        this.cl = cl;
    }

    public PhoneNumber getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(PhoneNumber phoneNum) {
        this.phoneNum = phoneNum;
    }

    public BirthDay getBirthday() {
        return birthday;
    }

    public void setBirthday(BirthDay birthday) {
        this.birthday = birthday;
    }

    public String getCerti() {
        return certi;
    }

    public void setCerti(String certi) {
        this.certi = certi;
    }
}
