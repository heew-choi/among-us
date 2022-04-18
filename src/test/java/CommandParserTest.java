import database.Database;
import parserValidChecker.Option3Checker;
import parserValidChecker.OptionValidChecker;
import parserValidChecker.PrintOptionChecker;
import parserValidChecker.CompareOptionChecker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CommandParserTest {
    CommandParser tester;
    @BeforeEach
    void setUp() {
        List<String> commandList = Arrays.asList("ADD", "DEL", "SCH", "MOD");
        List<OptionValidChecker> optionCheckerList = new ArrayList<>();
        optionCheckerList.add(new PrintOptionChecker());
        optionCheckerList.add(new CompareOptionChecker());
        optionCheckerList.add(new Option3Checker());
        CommandFactory commandFactory = new CommandFactory(new Database());

        tester = new CommandParser(",", commandList, optionCheckerList, commandFactory);
    }

    @Nested
    @DisplayName("ADD Command")
    class ADDTest {

        @Test
        @DisplayName("정상 case")
        void parseCommand_ADD() {
            String inputStr = "ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV";
            ArrayList<String> expParams = new ArrayList<>(Arrays.asList("15123099", "VXIHXOTH JHOP", "CL3", "010-3112-2609", "19771211", "ADV"));

            Command command = tester.parseCommand(inputStr);
            assertEquals("ADD", command.getCommandType());
            assertArrayEquals(expParams.toArray(), command.params.toArray());
        }

    }

    @Nested
    @DisplayName("ADD Command")
    class DELTest {

        @Test
        @DisplayName("정상 case")
        void parseCommand_DEL() {
            String inputStr = "DEL,-p,-l, ,name,MPOSXU";
            ArrayList<String> expParams = new ArrayList<>(Arrays.asList("name", "MPOSXU"));

            Command command = tester.parseCommand(inputStr);
            assertEquals("DEL", command.getCommandType());
            assertArrayEquals(expParams.toArray(), command.params.toArray());
        }

    }

    @Nested
    @DisplayName("SCH Command")
    class SCHTest {

        @Test
        @DisplayName("정상 case")
        void parseCommand_SCH() {
            String inputStr = "SCH, ,-m, ,birthday,09";
            ArrayList<String> expParams = new ArrayList<>(Arrays.asList("birthday", "09"));

            Command command = tester.parseCommand(inputStr);
            assertEquals("SCH", command.getCommandType());
            assertArrayEquals(expParams.toArray(), command.params.toArray());
        }

    }

    @Nested
    @DisplayName("MOD Command")
    class MODTest {

        @Test
        @DisplayName("정상 case")
        void parseCommand_MOD() {
            String inputStr = "MOD,-p, , ,phoneNum,010-8900-1478,certi,PRO";
            ArrayList<String> expParams = new ArrayList<>(Arrays.asList("phoneNum", "010-8900-1478", "certi", "PRO"));

            Command command = tester.parseCommand(inputStr);
            assertEquals("MOD", command.getCommandType());
            assertArrayEquals(expParams.toArray(), command.params.toArray());
        }

    }
}