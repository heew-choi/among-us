package command;

import exceptions.ImproperlyConfigured;
import database.*;
import option.*;
import employee.*;
import utility.Logger;
import java.util.List;

public abstract class Command {
    protected final int paramCount;
    protected Database database;
    protected Option option;
    protected List<String> params;

    protected Command(Database database, int paramCount) {
        this.database = database;
        this.paramCount = paramCount;
    }

    protected void print(List<Employee> records) {
        Logger.appendLog(option.getPrintOption().report(records, getCommandType()));
    }

    protected boolean isParamCountValid() {
        if (params.size() != paramCount)
            throw new ArithmeticException("Parameter count mismatch");
        return true;
    }

    public Database getDatabase() {
        return database;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    public List<String> getParams() {
        return params;
    }

    public void setParams(List<String> params) {
        this.params = params;
    }

    public abstract String getCommandType();
    public abstract void run() throws ImproperlyConfigured;
}
