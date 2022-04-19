package command;

import database.Database;
import employee.Employee;
import exceptions.ImproperlyConfigured;

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
    public void run() throws ImproperlyConfigured {
        if (!isParamCountValid() || isDuplicatedEmployee())
            return;

        Employee newbie = makeNewbie(params);
        database.insert(newbie);
    }

    private boolean isDuplicatedEmployee() {
        return !database.select(option.compareOption).isEmpty();
    }

    public Employee makeNewbie(List<String> params) throws ImproperlyConfigured {
        String empNum = params.get(0);
        String name = params.get(1);
        String cl = params.get(2);
        String phoneNum = params.get(3);
        String birthday = params.get(4);
        String certi = params.get(5);
        return new Employee(empNum, name, cl, phoneNum, birthday, certi);
    }
}
