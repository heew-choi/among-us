package command;

import exceptions.ImproperlyConfigured;
import database.*;
import option.*;
import employee.*;
import utility.Logger;

import java.util.ArrayList;
import java.util.List;

public abstract class Command {
    protected Database database;
    protected Option option;
    protected List<String> params;

    public Command(Database database) {
        this.database = database;
    }

    public Database getDatabase() {
        return database;
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

    protected void print(ArrayList<Employee> records) {
        Logger.appendLog(option.printOption.report(records, getCommandType()));
    }

    public abstract String getCommandType();

    public abstract void run() throws ImproperlyConfigured;
}
