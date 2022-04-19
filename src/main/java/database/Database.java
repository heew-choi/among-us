package database;

import employee.Employee;
import option.compare.CompareOption;

import java.util.*;
import java.util.stream.Collectors;

public class Database {
    private final List<Employee> employees;
    private final Set<String> usedEmpNumbers = new HashSet<>();
    private boolean sorted = false;

    public Database() {
        this.employees = new ArrayList<>();
    }

    public List<Employee> select() {
        return employees;
    }

    public List<Employee> select(CompareOption option) {
        sortDatabase();
        return employees.stream()
                .filter(option::compare)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<Employee> select(CompareOption option, int limit) {
        sortDatabase();

        ArrayList<Employee> result = new ArrayList<>();

        for(Employee employee : employees) {
            if (option.compare(employee)) {
                result.add(employee);
                limit --;
            }

            if (limit == 0)
                break;
        }

        return result;
    }

    public void delete(Employee employee) {
        employees.remove(employee);
        usedEmpNumbers.remove(employee.getEmployeeNum().toString());
    }

    public void insert(Employee employee) {
        if (isDuplicateEmployeeNumber(employee.getEmployeeNum().toString())) return;

        usedEmpNumbers.add(employee.getEmployeeNum().toString());
        employees.add(employee);
        sorted = false;
    }

    public void update(Employee targetEmployee, Employee changedEmployee) {
        if (changedEmployee.isValid()) {
            targetEmployee.setName(changedEmployee.getName());
            targetEmployee.setCl(changedEmployee.getCl());
            targetEmployee.setPhoneNum(changedEmployee.getPhoneNum());
            targetEmployee.setBirthday(changedEmployee.getBirthday());
            targetEmployee.setCerti(changedEmployee.getCerti());
        }
    }

    private void sortDatabase() {
        if (!sorted) {
            employees.sort(Comparator.comparing(Employee::getFullEmployeeNumber));
            sorted = true;
        }
    }

    private boolean isDuplicateEmployeeNumber(String employeeNumber) {
        return usedEmpNumbers.contains(employeeNumber);
    }

}
