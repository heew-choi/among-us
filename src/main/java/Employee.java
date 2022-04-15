public class Employee {
    private int id;
    private EmployeeNumber employeeNum;
    private Name name;
    private String cl;
    private PhoneNumber phoneNum;
    private BirthDay birthday;
    private String certi;

    Employee (int id, EmployeeNumber employeeNum, Name name, String cl, PhoneNumber phoneNum, BirthDay birthday, String certi) {
        this.id = id;
        this.employeeNum = employeeNum;
        this.name = name;
        this.cl = cl;
        this.phoneNum = phoneNum;
        this.birthday = birthday;
        this.certi = certi;
    }

    public int getId() {
        return id;
    }

    public String getFullEmployeeNumber() {
        return employeeNum.getFullNumber();
    }

    public String getCerti() {
        return certi;
    }
}
