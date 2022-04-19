package commandParser.commandValidChecker;

import java.util.List;
import java.util.Objects;

public class PrintOptionChecker extends OptionValidChecker {
    @Override
    public boolean isValid(String option, List<String> params) {
        return option.trim().isEmpty() || Objects.equals(option, "-p");
    }

    @Override
    protected String getErrorMessage() {
        return "Invalid print option";
    }
}
