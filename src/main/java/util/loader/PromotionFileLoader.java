package util.loader;

import dto.promotion.PromotionDTO;

import static constants.ConvenienceErrorMessages.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class PromotionFileLoader implements FileLoader<PromotionDTO> {

    @Override
    public List<String> loadDataFromFile(String filePath) {
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
