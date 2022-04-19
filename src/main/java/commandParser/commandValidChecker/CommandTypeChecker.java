package commandParser.commandValidChecker;

import exceptions.InvalidCommandException;

import java.util.List;

public class CommandTypeChecker {
    private final List<String> commandList;

    public CommandTypeChecker(List<String> commandList) {
        this.commandList = commandList;
    }

    public void check(String commandType) {
        if (!isValid(commandType))
            throw new InvalidCommandException("Invalid command type");
    }

    public boolean isValid(String commandType) {
        return commandList.contains(commandType);
    }
}
