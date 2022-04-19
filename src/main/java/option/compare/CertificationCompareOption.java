package option.compare;

import employee.Employee;

public class CertificationCompareOption extends CompareOption {

    public CertificationCompareOption(String query) {
        super(query);
    }

    @Override
    public boolean compare(Employee employee) {
        return employee.getCerti().toString().equals(query);
    }
}