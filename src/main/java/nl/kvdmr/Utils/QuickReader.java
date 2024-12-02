package nl.kvdmr.Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class QuickReader {
    public static List<String> read(String path) throws IOException {
        return Files.readAllLines(Paths.get("src/main/java/nl/kvdmr/" + path).toAbsolutePath());
    }
}
