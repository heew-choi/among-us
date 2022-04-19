package command;

import database.Database;
import employee.Employee;
import option.print.ListPrintOption;

import java.util.List;

public class SearchCommand extends Command {
    private List<Employee> testResult;

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
        if (option.getPrintOption() instanceof ListPrintOption) {
            testResult = database.select(option.getCompareOption(), option.getPrintOption().getPrintLimit());
        }else {
            testResult = database.select(option.getCompareOption());
        }
        print(testResult);
    }

    public List<Employee> getTestResult() {
        return testResult;
    }
}
