package commandParser.commandValidChecker;

import java.util.*;

public class CompareOptionChecker extends OptionValidChecker {
    private final Map<String, List<String>> columnOptionMap;

    public CompareOptionChecker() {
        this.columnOptionMap = new HashMap<>();
        this.columnOptionMap.put("name", Arrays.asList("-f", "-l"));
        this.columnOptionMap.put("phoneNum", Arrays.asList("-m", "-l"));
        this.columnOptionMap.put("birthday", Arrays.asList("-y", "-m", "-d"));
    }

    @Override
    public boolean isValid(String option, List<String> params) {
        if (option.trim().isEmpty())
            return true;
        return columnOptionMap.containsKey(params.get(0)) && columnOptionMap.get(params.get(0)).contains(option);
    }

    @Override
    protected String getErrorMessage() {
        return "Invalid search option";
    }
}
