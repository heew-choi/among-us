public class CommandFactory {

    public static Command getCommand(String commandType) {
        switch (commandType) {
            case "ADD":
                return new AddCommand();
            case "DEL":
                return new DeleteCommand();
            case "SCH":
                return new SearchCommand();
            case "MOD":
                return new ModifyCommand();
            default:
                return null;
        }
    }
}
