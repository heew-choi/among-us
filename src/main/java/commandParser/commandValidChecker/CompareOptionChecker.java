package commandParser.commandValidChecker;

import java.util.List;
import java.util.Objects;

public class CompareOptionChecker extends OptionValidChecker {
    @Override
    public boolean isValid(String option, List<String> params) {
        if (option.trim().isEmpty()) {
            return true;
        }
        else if (option.equals("-f")) {
            return Objects.equals(params.get(0), "name");
        }
        else if (option.equals("-l")) {
            return Objects.equals(params.get(0), "name") || Objects.equals(params.get(0), "phoneNum");
        }
        else if (option.equals("-m")) {
            return Objects.equals(params.get(0), "phoneNum") || Objects.equals(params.get(0), "birthday");
        }
        else if (option.equals("-y") || option.equals("-d")) {
            return Objects.equals(params.get(0), "birthday");
        }
        return false;
    }

    @Override
    protected String getErrorMessage() {
        return "Invalid search option";
    }
}
