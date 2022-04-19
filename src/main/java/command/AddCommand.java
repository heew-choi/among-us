package command;

import database.Database;
import employee.Employee;

import java.util.List;

public class AddCommand extends Command {
    public AddCommand(Database database) {
        super(database, 6);
    }

    @Override
    public String getCommandType() {
        return "ADD";
    }

    @Override
    public void run() {
        if (!isParamCountValid())
            return;

        Employee newbie = makeNewbie(params);
        database.insert(newbie);
    }

    public Employee makeNewbie(List<String> params) {
        return new Employee(params.get(0), params.get(1), params.get(2), params.get(3), params.get(4), params.get(5));
    }
}
