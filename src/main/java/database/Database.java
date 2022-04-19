package database;

import employee.Employee;
import employee.EmployeeNumber;
import option.compare.CompareOption;
import option.compare.EmployeeNumberCompareOption;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Database {
    private List<Employee> employees;

    public Database() {
        this.employees = new ArrayList<>();
    }

    public List<Employee> select() {
        return employees;
    }

    public List<Employee> select(CompareOption option) {
        return employees.stream()
                .filter(option::compare)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public void delete(Employee employee) {
        employees.remove(employee);
    }

    public void insert(Employee employee) {
        if (isDuplicateEmployeeNumber(employee.getEmployeeNum())) return;
        employees.add(getInsertPosition(employee), employee);
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

    private boolean isDuplicateEmployeeNumber(EmployeeNumber employeeNumber) {
        return !select(new EmployeeNumberCompareOption(employeeNumber.toString())).isEmpty();
    }

    private int getInsertPosition(Employee employee) {
        int min = 0;
        int max = employees.size() - 1;

        if (employees.isEmpty()) return 0;

        while(min <= max) {
            int mid = (min + max) / 2;

            if (employees.get(mid).getFullEmployeeNumber().compareTo(employee.getFullEmployeeNumber()) == 0) {
                return mid;
            } else if (employees.get(mid).getFullEmployeeNumber().compareTo(employee.getFullEmployeeNumber()) > 0) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return min;
    }
}
