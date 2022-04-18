import employee.Employee;
import option.Option;

import java.util.ArrayList;

public abstract class Command {
    ArrayList<String> params;
    DatabaseInterface databaseInterface;
    ArrayList<Option> options;

    public Command() {
        databaseInterface = new Database();
    }

    public String print(ArrayList<Employee> records) {
        return "";
    }

    public ArrayList<String> getParams() {
        return params;
    }

    public void setParams(ArrayList<String> params) {
        this.params = params;
    }

    public void setDatabaseInterface(DatabaseInterface databaseInterface) {
        this.databaseInterface = databaseInterface;
    }

    public ArrayList<Option> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<Option> options) {
        this.options = options;
    }

    public abstract String getCommandType();
    public abstract void run();
}
