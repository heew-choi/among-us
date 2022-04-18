import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AmongUsTest {
    @ParameterizedTest
    @CsvSource({
            "input_20_20.txt/output_20_20.txt/output.txt",
    })
    void mainTest(String paramStr) throws IOException {
        List<String> params = Arrays.asList(paramStr.split("/"));
        System.out.println(params);

        String []args = {params.get(0), params.get(2)};

        AmongUs.main(args);

        assertEquals(new String(Files.readAllBytes(Paths.get(params.get(1))), StandardCharsets.UTF_8),
                new String(Files.readAllBytes(Paths.get(params.get(2))), StandardCharsets.UTF_8));
    }
}
