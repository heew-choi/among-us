import database.Database;
import option.Option;
import option.compareOption.*;
import option.printOption.*;
import parserValidChecker.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CommandParser {
    private static final int MIN_SPLIT_CNT = 6;

    private final String delimiter;
    private final CommandTypeChecker commandTypeChecker;
    private final List<OptionValidChecker> optionCheckerList;
    private CommandFactory commandFactory;

    public CommandParser(String delimiter, List<String> commandList, List<OptionValidChecker> optionCheckerList, CommandFactory commandFactory) {
        this.delimiter = delimiter;
        this.commandTypeChecker = new CommandTypeChecker(commandList);
        this.optionCheckerList = optionCheckerList;
        this.commandFactory = commandFactory;
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

            Command command = commandFactory.getCommand(commandType);
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
        if (printOption.equals("-p")) {
            return new ListPrintOption();
        }
        return new CountPrintOption();
    }

    private CompareOption getCompareOption(String option, List<String> params) {
        if (Objects.equals(params.get(0), "employeeNum"))
            return new EmployeeNumberCompareOption(params.get(1));

        if (Objects.equals(params.get(0), "name")) {
            if (option.equals("-f"))
                return new FirstNameCompareOption(params.get(1));
            if (option.equals("-l"))
                return new LastNameCompareOption(params.get(1));
            return new NameCompareOption(params.get(1));
        }

        if (Objects.equals(params.get(0), "cl"))
            return new CareerLevelCompareOption(params.get(1));

        if (Objects.equals(params.get(0), "phoneNum")) {
            if (option.equals("-m"))
                return new MiddlePhoneNumberCompareOption(params.get(1));
            if (option.equals("-l"))
                return new LastPhoneNumberCompareOption(params.get(1));
            return new PhoneNumberCompareOption(params.get(1));
        }

        if (Objects.equals(params.get(0), "birthday")) {

            if (option.equals("-y"))
                return new BirthdayYearCompareOption(params.get(1));
            if (option.equals("-m"))
                return new BirthdayMonthCompareOption(params.get(1));
            if (option.equals("-d"))
                return new BirthdayDayCompareOption(params.get(1));
            return new BirthdayCompareOption(params.get(1));
        }

        if (Objects.equals(params.get(0), "certi"))
            return new CertificationCompareOption(params.get(1));

        return new DefaultCompareOption();
    }

}
