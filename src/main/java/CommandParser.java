import parserValidChecker.*;
import parserValidChecker.CommandTypeChecker;
import parserValidChecker.OptionValidChecker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandParser {
    private static final int MIN_SPLIT_CNT = 6;

    private final String delimiter;
    private final CommandTypeChecker commandTypeChecker;
    private final List<OptionValidChecker> optionCheckerList;

    public CommandParser(String delimiter, List<String> commandList, List<OptionValidChecker> optionCheckerList) {
        this.delimiter = delimiter;
        this.commandTypeChecker = new CommandTypeChecker(commandList);
        this.optionCheckerList = optionCheckerList;
    }

    public Command parseCommand(String line) {
        if (!isValidCommandLine(line))
            throw new ArithmeticException("Invalid command line format");

        try {
            List<String> tokens = Arrays.asList(line.split(delimiter));
            String commandType = tokens.get(0);
            List<String> options = tokens.subList(1, optionCheckerList.size() + 1);
            List<String> params = tokens.subList(optionCheckerList.size() + 1, tokens.size());
            checkArgsValidation(commandType, options, params);

            Command command = CommandFactory.getCommand(commandType);
            command.setParams(new ArrayList<String>(params));
            // To Do : Option 삽입 로직 추가

            return command;
        }
        catch (Exception e) {
            throw e;
        }
    }

    public  boolean isValidCommandLine(String line) {
        if (line == null ||
                line.length() == 0 ||
                line.split(delimiter).length < MIN_SPLIT_CNT) {
            return false;
        }
        return true;
    }

    public boolean checkArgsValidation(String commandType, List<String> options, List<String> params) {
        try {
            commandTypeChecker.check(commandType);

            if (optionCheckerList.size() != options.size())
                throw new ArithmeticException("Option count mismatch");

            for (int idx = 0; idx < options.size(); idx++) {
                optionCheckerList.get(idx).check(options.get(idx), params);
            }
        }
        catch (Exception e) {
            throw e;
        }
        return true;
    }

}
