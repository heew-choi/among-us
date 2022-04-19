package command;

import database.Database;
import employee.Employee;

import java.util.ArrayList;
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
        try {
            if (!isParamCountValid())
                return;

            List<Employee> targetEmpList = database.select(option.compareOption);
            if (targetEmpList.size() == 0) {
                print(targetEmpList);
                return;
            }

            for (Employee targetEmp : targetEmpList) {
                database.delete(targetEmp);
            }
            print(targetEmpList);
        }
        catch (Exception e) {
            throw e;
        }
    }
}
