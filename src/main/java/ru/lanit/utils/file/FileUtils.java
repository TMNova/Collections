package ru.lanit.utils.file;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

public interface FileUtils {
    public List<String> getContentLinesFromFile(String path, Charset charset) throws IOException;
}
