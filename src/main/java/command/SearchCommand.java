package command;

import database.Database;
import employee.Employee;

import java.util.ArrayList;

public class SearchCommand extends Command {
    private ArrayList<Employee> testResult;

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
            testResult = database.select(option.compareOption);
            print(testResult);
        }
        catch (Exception e) {
            throw e;
        }
    }

    public ArrayList<Employee> getTestResult() {
        return testResult;
    }
}
