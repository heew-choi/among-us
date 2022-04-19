package database;

import employee.Employee;
import option.compare.CompareOption;

import java.util.ArrayList;

public interface DatabaseInterface {
    ArrayList<Employee> select();
    ArrayList<Employee> select(Employee employee);
    ArrayList<Employee> select(CompareOption option);
    void insert(Employee employee);
    void delete(int id);
    void update(int id, Employee employee);
}
