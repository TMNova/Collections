package ru.lanit.utils;

import org.junit.BeforeClass;
import org.junit.Test;
import ru.lanit.repo.StreamRepository;
import ru.lanit.repo.StudentsStreamRepo;
import ru.lanit.utils.file.FileListUtils;
import ru.lanit.utils.file.FileUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class FileStreamUtilsTest {
    private static final String INCORRECT_PATH = "/src/test/java.txt";
    private static final String CORRECT_PATH = "src/main/resources/students.txt";

    private static List<String> list;

    private static StreamRepository repo;

    private static FileUtils fileUtils;

    @BeforeClass
    public static void createRepository() {
        repo = new StudentsStreamRepo();
    }

    @BeforeClass
    public static void createListOfStudents() throws IOException {
        fileUtils = new FileListUtils();
        list = fileUtils.getContentLinesFromFile(CORRECT_PATH, StandardCharsets.UTF_8);
    }

    @Test(expected = FileNotFoundException.class)
    public void incorrectPathShouldThrowException() throws IOException {
        fileUtils.getContentLinesFromFile(INCORRECT_PATH, StandardCharsets.UTF_8);
    }

}
