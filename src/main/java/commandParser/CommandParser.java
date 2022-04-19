package commandParser;

import command.Command;
import command.CommandFactory;
import commandParser.commandValidChecker.*;
import exceptions.InvalidCommandException;
import option.Option;
import option.compare.*;
import option.print.*;
import utility.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CommandParser {
    private static final int MIN_SPLIT_CNT = 6;

    private final String delimiter;
    private final CommandTypeChecker commandTypeChecker;
    private final List<OptionValidChecker> optionCheckerList;
    private final CommandFactory commandFactory;
    private final int printLimit;

    public CommandParser(String delimiter, List<String> commandList, List<OptionValidChecker> optionCheckerList, CommandFactory commandFactory, int printLimit) {
        this.delimiter = delimiter;
        this.commandTypeChecker = new CommandTypeChecker(commandList);
        this.optionCheckerList = optionCheckerList;
        this.commandFactory = commandFactory;
        this.printLimit = printLimit;
    }

    public Command parseCommand(String line) {
        if (!isValidCommandLine(line))
            throw new InvalidCommandException("Invalid command line format");

        try {
            List<String> tokens = Arrays.asList(line.split(delimiter));
            String commandType = tokens.get(0);
            List<String> options = tokens.subList(1, optionCheckerList.size() + 1);
            List<String> params = tokens.subList(optionCheckerList.size() + 1, tokens.size());

            checkArgsValidation(commandType, options, params);
            return getCommand(commandType, options, params);
        }
        catch (InvalidCommandException e) {
            Logger.logConsole(e.getMessage());
            throw e;
        }
    }

    private boolean isValidCommandLine(String line) {
        return !(line == null || line.length() == 0 || line.split(delimiter).length < MIN_SPLIT_CNT);
    }

    private void checkArgsValidation(String commandType, List<String> options, List<String> params) {
        try {
            commandTypeChecker.check(commandType);

            if (optionCheckerList.size() != options.size())
                throw new InvalidCommandException("Option count mismatch");

            for (int idx = 0; idx < options.size(); idx++) {
                optionCheckerList.get(idx).check(options.get(idx), params);
            }
        }
        catch (InvalidCommandException e) {
            Logger.logConsole(e.getMessage());
            throw e;
        }
    }

    private Command getCommand(String commandType, List<String> options, List<String> params) {
        Command command = commandFactory.getCommand(commandType);
        command.setParams(params);
        command.setOption(getCommandOption(options, params));
        return command;
    }

    private Option getCommandOption(List<String> options, List<String> params) {
        return new Option(getPrintOption(options.get(0)), getCompareOption(options.get(1), params.get(0), params.get(1)));
    }

    private IPrintOption getPrintOption(String printOption) {
        if (printOption.equals("-p")) {
            return new ListPrintOption(printLimit);
        }
        return new CountPrintOption();
    }

    private CompareOption getCompareOption(String option, String column, String query) {
        if (Objects.equals(column, "employeeNum"))
            return new EmployeeNumberCompareOption(query);

        if (Objects.equals(column, "name")) {
            if (option.equals("-f"))
                return new FirstNameCompareOption(query);
            if (option.equals("-l"))
                return new LastNameCompareOption(query);
            return new NameCompareOption(query);
        }

        if (Objects.equals(column, "cl"))
            return new CareerLevelCompareOption(query);

        if (Objects.equals(column, "phoneNum")) {
            if (option.equals("-m"))
                return new MiddlePhoneNumberCompareOption(query);
            if (option.equals("-l"))
                return new LastPhoneNumberCompareOption(query);
            return new PhoneNumberCompareOption(query);
        }

        if (Objects.equals(column, "birthday")) {
            if (option.equals("-y"))
                return new BirthdayYearCompareOption(query);
            if (option.equals("-m"))
                return new BirthdayMonthCompareOption(query);
            if (option.equals("-d"))
                return new BirthdayDayCompareOption(query);
            return new BirthdayCompareOption(query);
        }

        if (Objects.equals(column, "certi"))
            return new CertificationCompareOption(query);

        return new DefaultCompareOption();
    }

}
