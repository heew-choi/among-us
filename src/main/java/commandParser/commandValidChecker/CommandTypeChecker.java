package commandParser.commandValidChecker;

import java.util.List;

public class CommandTypeChecker {
    private final List<String> commandList;

    public CommandTypeChecker(List<String> commandList) {
        this.commandList = commandList;
    }

    public void check(String commandType) {
        if (!isValid(commandType))
            throw new ArithmeticException("Invalid command type");
    }

    public boolean isValid(String commandType) {
        return commandType.contains(commandType);
    }
}
