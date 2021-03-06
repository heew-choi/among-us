package command;

import database.Database;
import employee.*;
import exceptions.InvalidCommandException;

import java.util.List;

public class ModifyCommand extends Command {
    public ModifyCommand(Database database) {
        super(database, 4);
    }

    @Override
    public String getCommandType() {
        return "MOD";
    }

    @Override
    public void run() {
        if (!isParamCountValid())
            return;

        List<Employee> targetEmpList = database.select(option.getCompareOption());
        print(targetEmpList);

        if (targetEmpList.isEmpty())
            return;

        String updateCol = params.get(2);
        String updateVal = params.get(3);
        for (Employee targetEmp : targetEmpList) {
            database.update(targetEmp, getUpdatedEmployee(targetEmp, updateCol, updateVal));
        }
    }

    private Employee getUpdatedEmployee(Employee originEmployee, String column, String updateValue) {
        Employee updatedEmp = new Employee(originEmployee);

        switch (column) {
            case "employeeNum":
                updatedEmp.setEmployeeNum(new EmployeeNumber(updateValue));
                break;
            case "name":
                updatedEmp.setName(new Name(updateValue));
                break;
            case "cl":
                updatedEmp.setCl(new CareerLevel(updateValue));
                break;
            case "phoneNum":
                updatedEmp.setPhoneNum(new PhoneNumber(updateValue));
                break;
            case "birthday":
                updatedEmp.setBirthday(new BirthDay(updateValue));
                break;
            case "certi":
                updatedEmp.setCerti(new CertificationLevel(updateValue));
                break;
            default:
                throw new InvalidCommandException("Invalid column name (" + column + ")");
        }
        return updatedEmp;
    }
}
