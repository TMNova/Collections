package ru.lanit.repo;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.lanit.repo.dto.Student;
import ru.lanit.utils.Converter;
import ru.lanit.utils.file.FileListUtils;
import ru.lanit.utils.file.FileUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class StudentsStreamRepoTest {

    private static final String PATH = "src/main/resources/students.txt";

    private static StreamRepository repo;

    private static List<String> list;

    private static List<Student> studentList;

    @BeforeClass
    public static void createRepository() {
        repo = new StudentsStreamRepo();
    }

    @BeforeClass
    public static void createLists() throws IOException {
        FileUtils fileUtils = new FileListUtils();
        list = fileUtils.getContentLinesFromFile(PATH, StandardCharsets.UTF_8);
        studentList = Converter.toStudentList(list);
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
        final int ACTUAL_VALUE = repo.getUniqueStudents(studentList).size();

        Assert.assertEquals(EXPECTED_VALUE, ACTUAL_VALUE);
    }

    @Test
    public void shouldReturnSortedByNameAndDate() {
        final List<String> EXPECTED_LIST = new ArrayList<>() {{
            add("Андреева Ангелина Андреевна - 11.12.1999");
            add("Антонов Алексей Григорьевич - 15.05.1996");
            add("Антонов Алексей Григорьевич - 15.05.2000");
            add("Захаров Максим Владимирович - 15.05.1994");
            add("Максимов Анатолий Евгеньевич - 15.05.1997");
        }};
        final List<String> ACTUAL_LIST = repo.sortedByNameAndDate(studentList);

        Assert.assertEquals(EXPECTED_LIST, ACTUAL_LIST);
    }

    @Test
    public void shouldReturnNameByCourse() {
        final List<String> EXPECTED_VALUE = new ArrayList<>() {{
            add("Захаров Максим Владимирович");
        }};
        final List<String> ACTUAL_VALUE = repo.getStudentsByCourse(studentList, 5);

        Assert.assertEquals(EXPECTED_VALUE, ACTUAL_VALUE);

    }

    @Test
    public void shouldReturnNameByClass() {
        final List<String> EXPECTED_VALUE = new ArrayList<>() {{
            add("Максимов Анатолий Евгеньевич");
            add("Антонов Алексей Григорьевич");
        }};
        final List<String> ACTUAL_VALUE = repo.getStudentsByClass(studentList, "русский язык");

        Assert.assertEquals(EXPECTED_VALUE, ACTUAL_VALUE);

    }

}
