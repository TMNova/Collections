package ru.lanit.view;

import ru.lanit.repo.StreamRepository;
import ru.lanit.repo.StudentsStreamRepo;
import ru.lanit.repo.dto.Student;
import ru.lanit.utils.Converter;
import ru.lanit.utils.file.FileStreamUtils;
import ru.lanit.utils.file.FileUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class StudentsInitStream {

    private static final FileUtils FILE_UTILS = new FileStreamUtils();

    private static final StreamRepository REPOSITORY = new StudentsStreamRepo();

    public static void show(String path) throws IOException {
         /* 1 задание:
        загрузил в память
        создал метод, получающий лист из строк
        создал метод, инициализируеющий из списка строк объект студент*/
        System.out.println("Создаю коллекции");
        List<String> list = FILE_UTILS.getContentLinesFromFile(path, StandardCharsets.UTF_8);
        List<Student> studentList = Converter.toStudentList(list);
        System.out.println();

        //2 задание

        //Вывод строки под определенным номером
        System.out.println("Вывод строки под определенным номером:");
        System.out.println(REPOSITORY.getLine(list, 1));
        System.out.println();

        //Вывод студентов в том порядке, в котором они появились в файле (уникальные)
        System.out.println("Вывод уникальных студентов в порядке списка файла:");
        System.out.println(REPOSITORY.getUniqueStudents(studentList));
        System.out.println();

        //Вывод студентов (уникальных) отсортированных по ФИО+дата рождения
        System.out.println("Вывод уникальных студентов отсортированных по ФИО+ДР:");
        System.out.println(REPOSITORY.sortedByNameAndDate(studentList));
        System.out.println();

        //Вывод студентов (уникальных) определенного курса
        System.out.println("Вывод уникальных студентов определенного курса:");
        System.out.println(REPOSITORY.getStudentsByCourse(studentList, 3));
        System.out.println();

        //Вывод студентов по предмету
        System.out.println("Вывод студентов по предмету:");
        System.out.println(REPOSITORY.getStudentsByClass(studentList, "русский язык"));
        System.out.println();

    }
}
