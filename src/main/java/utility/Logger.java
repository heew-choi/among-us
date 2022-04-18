package utility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Logger {
    private static File file = null;
    private static final String OUTPUT_FILE_PATH = "output.txt";
    private static ArrayList<String> printBuffer = new ArrayList<>();

    private Logger() {
        throw new IllegalStateException("Utility class");
    }

    public static void logConsole(String message) {
        System.out.println(message);
    }

    public static void appendLog(String message) {
        printBuffer.add(message);
    }

    public static void flushLogToFile() {
        if (!getOrCreateFile()) {
            return;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, false))) {
            for (String message: printBuffer) {
                writer.write(message);
                writer.newLine();
            }
            writer.flush();
            printBuffer.clear();
        } catch (IOException ex) {
            logConsole("IO Exception in logger");
            logConsole(ex.toString());
        }
    }

    public static void flushLogToConsole() {
        for (String message: printBuffer) {
            logConsole(message);
        }
    }

    public static void logFile(String message) {
        if (!getOrCreateFile()) {
            return;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(message);
            writer.newLine();
            writer.flush();
        } catch (IOException ex) {
            logConsole("IO Exception in logger");
            logConsole(ex.toString());
        }
    }

    private static boolean getOrCreateFile() {
        if (file == null) {
            file = new File(OUTPUT_FILE_PATH);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                }catch (IOException ex) {
                    logConsole("Output file create failed!");
                    return false;
                }
            }
        }
        return true;
    }
}
