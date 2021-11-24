package ru.lanit.view;

import ru.lanit.repo.Repository;
import ru.lanit.repo.StudentsRepo;
import ru.lanit.utils.Converter;
import ru.lanit.utils.file.FileListUtils;
import ru.lanit.utils.file.FileUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class StudentsInit {

    private static final FileUtils FILE_UTILS = new FileListUtils();

    private static final Repository REPOSITORY = new StudentsRepo();
    
    public static void show(String path) throws IOException {
         /* 1 задание:
        загрузил в память
        создал метод, получающий лист из строк
        создал метод, получающий из листа строк мапу с необходимыми ключами и значениями из списка*/
        System.out.println("Создаю коллекции");
        List<String> list = FILE_UTILS.getContentLinesFromFile(path, StandardCharsets.UTF_8);
        List<Map<String, String>> mapList = Converter.toStudentsMapList(list);
        System.out.println();

        //2 задание

        //Вывод строки под определенным номером
        System.out.println("Вывод строки под определенным номером:");
        System.out.println(REPOSITORY.getLine(list, 1));
        System.out.println(REPOSITORY.getLine(list, 0));
        System.out.println(REPOSITORY.getLine(list, 100));
        System.out.println();

        //Вывод студентов в том порядке, в котором они появились в файле (уникальные)
        System.out.println("Вывод уникальных студентов в порядке списка файла:");
        System.out.println(REPOSITORY.getUniqueStudents(mapList));
        System.out.println();

        //Вывод студентов (уникальных) отсортированных по ФИО+дата рождения
        System.out.println("Вывод уникальных студентов отсортированных по ФИО+ДР:");
        System.out.println(REPOSITORY.sortedByNameAndDate(mapList));
        System.out.println();

        //Вывод студентов (уникальных) определенного курса
        System.out.println("Вывод уникальных студентов определенного курса:");
        System.out.println(REPOSITORY.getStudentsByCourse(mapList, 3));
        System.out.println();

        //Вывод студентов по предмету
        System.out.println("Вывод студентов по предмету:");
        System.out.println(REPOSITORY.getStudentsByClass(mapList, "русский язык"));
        System.out.println();

    }
}
