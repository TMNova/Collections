package ru.lanit.utils.file;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class FileStreamUtils implements FileUtils{

    @Override
    public List<String> getContentLinesFromFile(String path, Charset charset) throws IOException {
        Path filePath = Paths.get(path);
        Stream<String> lines = Files.lines(filePath, charset);

        List<String> linesList = lines.toList();

        return linesList;
    }
}
