import option.Option;

import java.util.List;

public abstract class Command {
    DatabaseInterface databaseInterface;
    Option option;
    List<String> params;

    public Command() {
        this.databaseInterface = new Database();
    }

    public String print(List<Employee> records) {
        return "";
    }

    public List<String> getParams() {
        return params;
    }

    public void setParams(List<String> params) {
        this.params = params;
    }

    public void setDatabaseInterface(DatabaseInterface databaseInterface) {
        this.databaseInterface = databaseInterface;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    public abstract String getCommandType();
    public abstract void run();
}
