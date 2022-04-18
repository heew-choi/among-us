package commandParser.commandValidChecker;

import java.util.List;

public class Option3Checker extends OptionValidChecker{
    @Override
    public boolean isValid(String option, List<String> params) {
        return true;
    }

    @Override
    protected String getErrorMessage() {
        return "Invalid unknown option";
    }
}
