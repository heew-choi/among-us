import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class CommandParser {
    private static final String[] COMMAND_LIST = {"ADD", "DEL", "SCH", "MOD"};
    private static final String DELIMITER = ",";
    private static final int MIN_SPLIT_CNT = 6;

    public static Command parseCommand(String line) {
        if (!isValidString(line)){
            return null;
        }

        // Command line 분리
        String[] tokens = line.split(DELIMITER);
        String commandType = tokens[0];
        String option1 = tokens[1];
        String option2 = tokens[2];
        String option3 = tokens[3];
        String[] params = Arrays.copyOfRange(tokens, 4, tokens.length);

        // 유효성 검사
        if (!isValidCommandType(commandType) ||
            !isValidOption1(option1) ||
            !isValidOption2(option2, params) ||
            !isValidOption3(option3, params)) {
            return null;
        }

        // Command 객체 생성
        Command command = getCommand(commandType);
        command.setParams(new ArrayList<String>(Arrays.asList(params)));

        // To Do : Option 삽입 로직 추가

        return command;
    }

    public static boolean isValidString(String line) {
        // empty
        if (line == null ||
            line.length() == 0 ||
            line.split(DELIMITER).length < MIN_SPLIT_CNT) {
            return false;
        }
        return true;
    }

    public static boolean isValidCommandType(String commandType) {
        System.out.println("커맨드 타입 확인");
        return Arrays.asList(COMMAND_LIST).contains(commandType);
    }

    public static boolean isValidOption1(String option) {
        System.out.println("옵션1 확인");
        return option.trim().isEmpty() || Objects.equals(option, "-p");
    }

    public static boolean isValidOption2(String option, String[] params) {
        System.out.println("옵션2 확인");
        if (option.trim().isEmpty()) {
            return true;
        }
        else if (option.equals("-f")) {
            return Objects.equals(params[0], "name");
        }
        else if (option.equals("-l")) {
            return Objects.equals(params[0], "name") || Objects.equals(params[0], "phoneNum");
        }
        else if (option.equals("-m")) {
            return Objects.equals(params[0], "phoneNum") || Objects.equals(params[0], "birthday");
        }
        else if (option.equals("-y") || option.equals("-d")) {
            return Objects.equals(params[0], "birthday");
        }
        return false;
    }

    public static boolean isValidOption3(String option, String[] params) {
        return true;
    }

    public static Command getCommand(String commandType) {
        switch (commandType) {
            case "ADD":
                return new AddCommand();
            case "DEL":
                return new DeleteCommand();
            case "SCH":
                return new SearchCommand();
            case "MOD":
                return new ModifyCommand();
            default:
                return null;
        }
    }

}
