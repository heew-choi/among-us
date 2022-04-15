import java.util.ArrayList;

public abstract class CompareOption {
    protected String column;
    protected String value;

    public abstract ArrayList<Employee> filter(ArrayList<Employee> employees);
}
