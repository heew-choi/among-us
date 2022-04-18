package command;

import command.*;
import database.Database;

public class CommandFactory {
    private Database database;

    public CommandFactory(Database database) {
        this.database = database;
    }

    public Command getCommand(String commandType) {
        switch (commandType) {
            case "ADD":
                return new AddCommand(database);
            case "DEL":
                return new DeleteCommand(database);
            case "SCH":
                return new SearchCommand(database);
            case "MOD":
                return new ModifyCommand(database);
            default:
                return null;
        }
    }
}
