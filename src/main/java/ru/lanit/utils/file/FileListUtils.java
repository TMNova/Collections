package ru.lanit.utils.file;


import java.io.*;
import java.nio.charset.Charset;
import java.util.*;

public class FileListUtils implements FileUtils{
    
    public List<String> getContentLinesFromFile(String path, Charset charset) throws IOException {
        List<String> list = new ArrayList<>();
        InputStream file = new FileInputStream(path);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file, charset));

        String line;

        while ((line = bufferedReader.readLine()) != null) {
            list.add(line);
        }
        
        file.close();
        bufferedReader.close();

        return list;
    }
    
}
