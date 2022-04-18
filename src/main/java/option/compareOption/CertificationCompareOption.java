package option.compareOption;

import employee.Employee;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class CertificationCompareOption extends CompareOption {

    public CertificationCompareOption(String query) {
        super(query);
    }

    @Override
    public boolean compare(Employee employee) {
        return employee.getCerti().toString().equals(query);
    }
}