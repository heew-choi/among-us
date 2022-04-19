package command;

import database.Database;
import employee.Employee;

import java.util.ArrayList;
import java.util.List;

public class SearchCommand extends Command {
    public List<Employee> testResult;

    public SearchCommand(Database database) {
        super(database, 2);
    }

    @Override
    public String getCommandType() {
        return "SCH";
    }

    @Override
    public void run() {
        if (!isParamCountValid())
            return;

        try {
//            print(database.select(option.compareOption));
            testResult = database.select(option.compareOption);
            print(testResult);
        }
        catch (Exception e) {
            throw e;
        }
    }
}
