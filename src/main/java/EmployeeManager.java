import command.CommandFactory;
import commandParser.CommandParser;
import database.Database;
import commandParser.commandValidChecker.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeManager {
    private final CommandParser commandParser;

    public EmployeeManager() {
        List<String> commandList = Arrays.asList("ADD", "DEL", "SCH", "MOD");
        List<OptionValidChecker> optionCheckerList = new ArrayList<>();
        optionCheckerList.add(new PrintOptionChecker());
        optionCheckerList.add(new CompareOptionChecker());
        optionCheckerList.add(new Option3Checker());
        CommandFactory commandFactory = new CommandFactory(new Database());

        commandParser = new CommandParser(",", commandList, optionCheckerList, commandFactory, 5);
    }

    public void runCommand(String line) {
        commandParser.parseCommand(line).run();
    }
}
