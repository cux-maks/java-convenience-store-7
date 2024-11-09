package util.loader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static constants.ConvenienceErrorMessages.FILE_NOT_FOUND;

public class FileLoader {
    public static List<String> loadDataFromFile(String filePath) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            lines.removeFirst();
            return lines;
        } catch (IOException e) {
            throw new IllegalArgumentException(
                    String.format(FILE_NOT_FOUND.getMessage(), filePath)
            );
        }
    }
}
