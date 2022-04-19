package employee;

public class Employee {
    private EmployeeNumber employeeNum;
    private Name name;
    private CareerLevel cl;
    private PhoneNumber phoneNum;
    private BirthDay birthday;
    private CertificationLevel certi;

    public Employee() {
    }

    public Employee(String strEmployeeNum, String strName, String cl, String strPhoneNumber, String strBirthday, String certi) {
        this.employeeNum = new EmployeeNumber(strEmployeeNum);
        this.name = new Name(strName);
        this.cl = new CareerLevel(cl);
        this.phoneNum = new PhoneNumber(strPhoneNumber);
        this.birthday = new BirthDay(strBirthday);
        this.certi = new CertificationLevel(certi);
    }

    public Employee(Employee employee) {
        employeeNum = new EmployeeNumber(employee.getEmployeeNum().toString());
        name = new Name(employee.getName().toString());
        cl = new CareerLevel(employee.getCl().toString());
        phoneNum = new PhoneNumber(employee.getPhoneNum().toString());
        birthday = new BirthDay(employee.getBirthday().toString());
        certi = new CertificationLevel(employee.getCerti().toString());
    }

    public boolean isValid() {
        return employeeNum.isValid() &&
                name.isValid() &&
                phoneNum.isValid() &&
                birthday.isValid() &&
                cl.isValid() &&
                certi.isValid();
    }

    public String toString() {
        String[] strings = {
                employeeNum.toString(),
                name.toString(),
                cl.toString(),
                phoneNum.toString(),
                birthday.toString(),
                certi.toString()
        };
        return String.join(",", strings);
    }

    public String getFullEmployeeNumber() {
        return employeeNum.getFullNumber();
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

    public CareerLevel getCl() {
        return cl;
    }

    public void setCl(CareerLevel cl) {
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

    public CertificationLevel getCerti() {
        return certi;
    }

    public void setCerti(CertificationLevel certi) {
        this.certi = certi;
    }
}
