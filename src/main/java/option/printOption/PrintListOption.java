package option.printOption;

import employee.Employee;
import option.printOption.IPrintOption;

import java.util.ArrayList;

public class PrintListOption implements IPrintOption {

    @Override
    public String report(ArrayList<Employee> employees) {
        if (employees.size() == 0)
            return "NONE";

        StringBuffer result = new StringBuffer();
        int i = 0;
        for (Employee employee : employees) {

            try {
//                result += employees.toString();;
                result.append(employees.toString());
            } catch (NullPointerException e) {
                ;
                // 예외 처리 정책 수립 필요
            }

            i++;
            if (i >= 5)
                break;
        }

        return result.toString();
    }
}
