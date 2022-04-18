import employee.Employee;

import java.util.ArrayList;

public class SearchCommand extends Command {
    public ArrayList<Employee> testResult;

    @Override
    public String getCommandType() {
        return "SCH";
    }

    @Override
    public void run() {
        try {
//            print(database.select(option.compareOption));

            // For unit test
            testResult = database.select(option.compareOption);
            print(testResult);
        }
        catch (Exception e) {
            throw e;
        }
    }
}
