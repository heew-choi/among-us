import employee.Employee;

import java.util.ArrayList;

public interface DatabaseInterface {
    public ArrayList<Employee> select(Employee employee);
    public ArrayList<Employee> insert(Employee employee);
    public ArrayList<Employee> delete(int id);
    public ArrayList<Employee> update(int id, Employee employee);
}
