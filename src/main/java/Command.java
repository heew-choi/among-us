import database.*;
import option.*;
import employee.*;

import java.util.ArrayList;

public abstract class Command {
    ArrayList<String> params;
    Database database;
    ArrayList<Option> options;

    public Command() {
        database = new Database();
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

    public void setDatabase(Database database) {
        this.database = database;
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
