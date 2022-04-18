import exceptions.ImproperlyConfigured;
import database.*;
import option.*;
import employee.*;

import java.util.ArrayList;
import java.util.List;

public abstract class Command {
    Database database;
    Option option;
    List<String> params;

    public Command() {
        this.database = new Database();
    }

    public List<String> getParams() {
        return params;
    }

    public void setParams(List<String> params) {
        this.params = params;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    public String print(ArrayList<Employee> records) {
        System.out.println(option.printOption.report(records));;
    }

    public abstract String getCommandType();

    public abstract void run() throws ImproperlyConfigured;
}
