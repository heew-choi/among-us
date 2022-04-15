import java.util.ArrayList;

public abstract class Command {
    ArrayList<String> params;
    DatabaseInterface databaseInterface;
    ArrayList<Option> options;

    public void print() {

    }
}
