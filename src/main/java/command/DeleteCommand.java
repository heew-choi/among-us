package command;

import database.Database;
import employee.Employee;

import java.util.ArrayList;

public class DeleteCommand extends Command {
    public DeleteCommand(Database database) {
        super(database);
    }

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
                database.delete(targetEmp);
            }
            print(targetEmpList);
        }
        catch (Exception e) {
            throw e;
        }
    }
}
