package database;

import employee.Employee;
import employee.EmployeeNumber;
import option.compareOption.CompareOption;
import option.compareOption.LastNameCompareOption;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Database {
    private ArrayList<Employee> employees;

    public Database() {
        this.employees = new ArrayList<>();
    }

    public ArrayList<Employee> select() {
        return employees;
    }

    public ArrayList<Employee> select(CompareOption option) {
        return option.filter(employees);
    }

    public void delete(int index) {
        employees.remove(index);
    }

    public void insert(Employee employee) {
        if (isDuplicateEmployeeNumber(employee.getEmployeeNum())) return;
        employees.add(getInsertPosition(employee), employee);
    }

    public void update(int index, Employee employee) {
        Employee targetEmployee = employees.get(index);
        if (targetEmployee.isValid()) {
            targetEmployee.setName(employee.getName());
            targetEmployee.setCl(employee.getCl());
            targetEmployee.setPhoneNum(employee.getPhoneNum());
            targetEmployee.setBirthday(employee.getBirthday());
            targetEmployee.setCerti(employee.getCerti());
        }
    }

    private boolean isDuplicateEmployeeNumber(EmployeeNumber employeeNumber) {
        return employees.stream().filter(emp -> emp.getEmployeeNum().toString().equals(employeeNumber.toString())).collect(Collectors.toCollection(ArrayList::new)).size() > 0;
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
