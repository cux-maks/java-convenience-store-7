package util.loader;

import java.io.IOException;
import java.util.List;

public interface FileLoader<T> {
    List<String> loadDataFromFile(String filePath) throws IOException;
}
