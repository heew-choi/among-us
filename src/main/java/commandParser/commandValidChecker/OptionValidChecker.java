package commandParser.commandValidChecker;

import exceptions.InvalidCommandException;

import java.util.List;

public abstract class OptionValidChecker {
    public void check(String option, List<String> params) {
        if (!isValid(option, params))
            throw new InvalidCommandException(getErrorMessage());
    }

    protected abstract boolean isValid(String option, List<String> params);
    protected abstract String getErrorMessage();
}
