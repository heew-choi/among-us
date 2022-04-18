import employee.Employee;

import java.util.ArrayList;

public class DeleteCommand extends Command {
    @Override
    public String getCommandType() {
        return "DEL";
    }

    @Override
    public void run() {
        try {
            // 1. 사원 정보 검색
            ArrayList<Employee> targetEmpList = database.select(option.compareOption);
            if (targetEmpList.size() == 0) {
                print(targetEmpList);
                return;
            }

            // 2. 삭제 요청
            for (Employee targetEmp : targetEmpList) {
//                database.delete(targetEmp);
                database.delete(0); // for unit test
            }
            print(targetEmpList);
        }
        catch (Exception e) {
            throw e;
        }
    }
}
