package ru.lanit;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CollectionsCompareTest {
    private static final String INCORRECT_PATH = "/src/test/java.txt";
    
    @Test(expected = FileNotFoundException.class)
    public void incorrectPathShouldThrowException() throws IOException {
        CollectionsCompare.show(INCORRECT_PATH);
    }
}
