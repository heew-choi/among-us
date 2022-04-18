package option.printOption;

import employee.Employee;

import java.util.ArrayList;

public class ListPrintOption implements IPrintOption {

    final int PRINT_LIMIT = 5;

    @Override
    public String report(ArrayList<Employee> employees, String commandName) {
        if (employees.size() == 0)
            return "NONE";

        StringBuffer result = new StringBuffer();
        int i = 0;
        for (Employee employee : employees) {

            try {
//                result += employees.toString();;
//                result.append(employee.toString());
                result.append(commandName + ',' + employee.toString() + '\n');
            } catch (NullPointerException e) {
                ;
                // 예외 처리 정책 수립 필요
            }

            i++;
            if (i >= PRINT_LIMIT)
                break;
        }

        return result.toString();
    }
}
