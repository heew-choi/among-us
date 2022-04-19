package command;

import database.Database;
import employee.Employee;
import exceptions.ImproperlyConfigured;

import java.util.List;

public class DeleteCommand extends Command {
    public DeleteCommand(Database database) {
        super(database, 2);
    }

    @Override
    public String getCommandType() {
        return "DEL";
    }

    @Override
    public void run() {
        if (!isParamCountValid())
            return;

        List<Employee> targetEmpList = database.select(option.getCompareOption());
        if (targetEmpList.isEmpty()) {
            print(targetEmpList);
            return;
        }

        for (Employee targetEmp : targetEmpList) {
            database.delete(targetEmp);
        }
        print(targetEmpList);
    }
}
