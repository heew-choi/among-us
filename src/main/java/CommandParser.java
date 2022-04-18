import option.Option;
import option.compareOption.*;
import option.printOption.CountPrintOption;
import option.printOption.IPrintOption;
import option.printOption.ListPrintOption;
import parserValidChecker.CommandTypeChecker;
import parserValidChecker.OptionValidChecker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
            command.setOption(getCommandOption(options, params));

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

    private Option getCommandOption(List<String> options, List<String> params) {
        return new Option(getPritnOption(options.get(0), params), getCompareOption(options.get(1), params));
    }

    private IPrintOption getPritnOption(String printOption, List<String> params) {
        if (printOption == "-p") {
            return new ListPrintOption();
        }
        return new CountPrintOption();
    }

    private CompareOption getCompareOption(String option, List<String> params) {
        if (option.equals("-f") && Objects.equals(params.get(0), "name")) {
            return new FirstNameCompareOption("");
        }
        else if (option.equals("-l") && Objects.equals(params.get(0), "name")) {
            return new LastNameCompareOption("");
        }
        else if (option.equals("-m") && Objects.equals(params.get(0), "phoneNum")) {
            return new MiddlePhoneNumberCompareOption("");
        }
        else if (option.equals("-l") && Objects.equals(params.get(0), "phoneNum")) {
            return new LastPhoneNumberCompareOption("");
        }
        else if (option.equals("-y") && Objects.equals(params.get(0), "birthday")) {
            return new BirthdayYearCompareOption("");
        }
        else if (option.equals("-m") && Objects.equals(params.get(0), "birthday")) {
            return new BirthdayMonthCompareOption("");
        }
        else if (option.equals("-d") && Objects.equals(params.get(0), "birthday")) {
            return new BirthdayDayCompareOption("");
        }
        return new DefaultCompareOption("");
    }

}
