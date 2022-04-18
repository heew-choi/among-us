import database.Database;
import employee.Employee;
import exceptions.ImproperlyConfigured;

import java.util.ArrayList;
import java.util.List;

public class AddCommand extends Command {
    public ArrayList<Employee> testResult;

    public AddCommand(Database database) {
        super(database);
    }

    @Override
    public String getCommandType() {
        return "ADD";
    }

    @Override
    public void run() throws ImproperlyConfigured {
        try {
            // 1. 사원 정보 생성
            Employee newbie = makeNubie(params);

            // 2. 중복 여부 확인
            if (database.select(option.compareOption).size() > 0)
                return;

            // 3. 사원 정보 등록
            database.insert(newbie);
        }
        catch (Exception e) {
            throw e;
        }
    }

    public Employee makeNubie(List<String> params) throws ImproperlyConfigured {
        String empNum = params.get(0);
        String name = params.get(1);
        String cl = params.get(2);
        String phoneNum = params.get(3);
        String birthday = params.get(4);
        String certi = params.get(5);
        return new Employee(empNum, name, cl, phoneNum, birthday, certi);
    }
}
