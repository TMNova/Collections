package ru.lanit.utils;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class FileUtilsTest {
    private static final String INCORRECT_PATH = "/src/test/java.txt";
    private static final String CORRECT_PATH = "src/main/resources/students.txt";
    
    private static List<String> list;
    
    @BeforeClass
    public static void createListOfStudents() throws IOException {
        list = FileUtils.getContentLines(CORRECT_PATH, StandardCharsets.UTF_8);
    }
    
    @Test(expected = FileNotFoundException.class)
    public void incorrectPathShouldThrowException() throws IOException {
        FileUtils.getContentLines(INCORRECT_PATH, StandardCharsets.UTF_8);
    }
    
    @Test
    public void isAvailableNameShouldReturnFalse() {
        boolean actual = FileUtils.isAvailableName(list, null);
        Assert.assertEquals(true, actual);
    }
}
