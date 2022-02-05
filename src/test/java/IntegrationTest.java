import com.synalogik.Main;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IntegrationTest {

    private String testName;

    public IntegrationTest(String testName){
        this.testName = testName;
    }

    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][] {
                { "testFile1" },
           //     { "bible_daily" },  //<-- this is very slow when run in debug mode!
                { "utf8" },
                { "utf8_1" }, // some foreign words aren't recognised
                { "utf8_2"}  // e.g. russian words aren't recognised
        });
    }

    @Test
    public void test() throws IOException, URISyntaxException {
        PrintStream orig = System.out;

        String expected = Files.readString(getFilePath(testName + ".expected"), StandardCharsets.UTF_8);
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             PrintStream ps = new PrintStream(baos)
        ) {
            System.setOut(ps);
            Main.main(getFilePath(testName + ".txt").toString());
            baos.flush();
            String output = baos.toString(StandardCharsets.UTF_8);
            assertEquals(expected, output);
        } finally {
            System.setOut(orig);
        }
    }

    private Path getFilePath(String file) throws URISyntaxException {
        URL resource = this.getClass().getResource("/" + file);
        return Paths.get(resource.toURI());
    }
}
