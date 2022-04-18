import utility.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AmongUs {
    private static final String DEFAULT_INPUT_FILE_PATH = "input_20_20.txt";
    private static String inputFileName, outputFileName;

    public static void main(String[] args) {
        setupFiles(args);

        Logger.setOutputFilePath(outputFileName);

        EmployeeManager employeeManager = new EmployeeManager();
        try(BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                employeeManager.runCommand(line);
            }
        } catch(IOException ex) {
            Logger.logConsole("IO Exception occured");
            Logger.logConsole(ex.toString());
        }
    }

    private static void setupFiles(String[] args) {
        try {
            inputFileName = args[0];
        } catch (IndexOutOfBoundsException ex) {
            inputFileName = DEFAULT_INPUT_FILE_PATH;
        }
        try {
            outputFileName = args[1];
        } catch (IndexOutOfBoundsException ex) {
            outputFileName = "output.txt";
        }
    }
}
