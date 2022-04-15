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
}
