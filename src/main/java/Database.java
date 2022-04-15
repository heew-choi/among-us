import java.util.ArrayList;

public class Database implements DatabaseInterface {
    private ArrayList<Employee> employees;

    Database() {
        this.employees = new ArrayList<>();
    }

    @Override
    public ArrayList<Employee> select(Employee employee) {
        return employees;
    }

    @Override
    public ArrayList<Employee> delete(int id) {
        employees.remove(id);
        return employees;
    }

    @Override
    public ArrayList<Employee> insert(Employee employee) {
        employees.add(getInsertPosition(employee), employee);
        return employees;
    }

    @Override
    public ArrayList<Employee> update(int id, Employee employee) {
        return employees;
    }

    private int getInsertPosition(Employee employee) {
        for (Employee storedEmployee : employees) {
            if (storedEmployee.getFullEmployeeNumber().compareTo(employee.getFullEmployeeNumber()) > 0) {
                return employees.indexOf(storedEmployee);
            }
        }
        return employees.size();
    }
}
