import employee.Employee;
import exceptions.ImproperlyConfigured;

import java.util.ArrayList;
import java.util.List;

public class AddCommand extends Command {
    public ArrayList<Employee> testResult;

    @Override
    public String getCommandType() {
        return "ADD";
    }

    @Override
    public void run() throws ImproperlyConfigured {
        // 1. 사원 정보 생성
        Employee newbie = makeNubie(params);

        // 2. 중복 여부 확인
        if (database.select(newbie).size() > 0)
            return;

        // 3. 사원 정보 등록
        ArrayList<Employee> resultList = database.insert(newbie);
        testResult = resultList;
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
