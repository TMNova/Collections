package ru.lanit.repo;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.lanit.utils.Converter;
import ru.lanit.utils.file.FileListUtils;
import ru.lanit.utils.file.FileUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class StudentsRepoTest {

    private static final String PATH = "src/main/resources/students.txt";

    private static Repository repo;

    private static List<String> list;

    private static List<Map<String, String>> mapList;

    @BeforeClass
    public static void createRepository() {
        repo = new StudentsRepo();
    }

    @BeforeClass
    public static void createLists() throws IOException {
        FileUtils fileUtils = new FileListUtils();
        list = fileUtils.getContentLinesFromFile(PATH, StandardCharsets.UTF_8);
        mapList = Converter.toStudentsMapList(list);
    }

    @Test
    public void shouldReturnSelectedLine() {
        final String EXPECTED_VALUE = "Андреева Ангелина Андреевна, жен, 11.12.1999, 1, математика";
        final String ACTUAL_VALUE = repo.getLine(list, 2);

        Assert.assertEquals(EXPECTED_VALUE, ACTUAL_VALUE);
    }

    @Test
    public void shouldReturnCountOfUniqueNames() {
        final int EXPECTED_VALUE = 4;
        final int ACTUAL_VALUE = repo.getUniqueStudents(mapList).size();

        Assert.assertEquals(EXPECTED_VALUE, ACTUAL_VALUE);
    }

    @Test
    public void shouldReturnSortedByNameAndDate() {
        final Set<String> EXPECTED_LIST = new TreeSet<>() {{
            add("Андреева Ангелина Андреевна - 11.12.1999");
            add("Антонов Алексей Григорьевич - 15.05.1996");
            add("Антонов Алексей Григорьевич - 15.05.2000");
            add("Захаров Максим Владимирович - 15.05.1994");
            add("Максимов Анатолий Евгеньевич - 15.05.1997");
        }};
        final Set<String> ACTUAL_LIST = repo.sortedByNameAndDate(mapList);

        Assert.assertEquals(EXPECTED_LIST, ACTUAL_LIST);
    }

    @Test
    public void shouldReturnNameByCourse() {
        final Set<String> EXPECTED_VALUE = new TreeSet<>() {{
            add("Захаров Максим Владимирович - 5");
        }};
        final Set<String> ACTUAL_VALUE = repo.getStudentsByCourse(mapList, 5);

        Assert.assertEquals(EXPECTED_VALUE, ACTUAL_VALUE);

    }

    @Test
    public void shouldReturnNameByClass() {
        final List<String> EXPECTED_VALUE = new ArrayList<>() {{
            add("Максимов Анатолий Евгеньевич");
            add("Антонов Алексей Григорьевич");
        }};
        final List<String> ACTUAL_VALUE = repo.getStudentsByClass(mapList, "русский язык");

        Assert.assertEquals(EXPECTED_VALUE, ACTUAL_VALUE);

    }

    @Test
    public void isAvailableNameShouldReturnFalse() {
        boolean actual = repo.isAvailableName(list, null);
        Assert.assertEquals(true, actual);
    }

}
