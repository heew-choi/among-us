import utility.Logger;

import java.io.*;

public class Main {
    private static final String INPUT_FILE_PATH = "input_20_20.txt";

    public static void main(String[] args) {
        EmployeeManager employeeManager = new EmployeeManager();
        try(BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                employeeManager.runCommand(line);
            }
        } catch(IOException ex) {
            Logger.logConsole("IO Exception occured");
            Logger.logConsole(ex.toString());
        }
    }
}
