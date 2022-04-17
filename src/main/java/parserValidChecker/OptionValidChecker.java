package parserValidChecker;

import java.util.List;

public abstract class OptionValidChecker {
    public void check(String option, List<String> params) {
        if (!isValid(option, params))
            throw new ArithmeticException(getErrorMessage());
    }

    protected abstract boolean isValid(String option, List<String> params);
    protected abstract String getErrorMessage();
}
