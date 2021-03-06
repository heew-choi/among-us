package command;

import database.Database;
import employee.Employee;

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
        print(targetEmpList);

        if (targetEmpList.isEmpty())
            return;

        for (Employee targetEmp : targetEmpList) {
            database.delete(targetEmp);
        }
    }
}
