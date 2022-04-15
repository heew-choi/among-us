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
        return employees;
    }

    @Override
    public ArrayList<Employee> insert(Employee employee) {
        employees.add(employee);
        return employees;
    }

    @Override
    public ArrayList<Employee> update(int id, Employee employee) {
        return employees;
    }
}
