package command;

import database.Database;
import employee.*;
import exceptions.ImproperlyConfigured;

import java.util.ArrayList;

public class ModifyCommand extends Command {
    public ModifyCommand(Database database) {
        super(database, 4);
    }

    @Override
    public String getCommandType() {
        return "MOD";
    }

    @Override
    public void run() throws ImproperlyConfigured {
        try {
            if (!isParamCountValid())
                return;

            ArrayList<Employee> targetEmpList = database.select(option.compareOption);
            if (targetEmpList.size() == 0) {
                print(targetEmpList);
                return;
            }
            print(targetEmpList);

            String updateCol = params.get(2);
            String updateVal = params.get(3);
            for (Employee targetEmp : targetEmpList) {
                database.update(targetEmp, getUpdatedEmployee(targetEmp, updateCol, updateVal));
            }
        }
        catch (Exception e) {
            throw e;
        }
    }

    private Employee getUpdatedEmployee(Employee originEmployee, String column, String updateValue) throws ImproperlyConfigured {
        Employee updatedEmp = originEmployee;


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
                throw new ArithmeticException("Invlaid column name (" + column + ")");
        }
        return updatedEmp;
    }
}