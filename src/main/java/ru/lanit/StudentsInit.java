package ru.lanit;

import ru.lanit.utils.FileUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class StudentsInit {
    
    public static void show(String path) throws IOException {
         /* 1 задание:
        загрузил в память
        создал метод, получающий лист из строк
        создал метод, получающий из листа строк мапу с необходимыми ключами и значениями из списка*/
        System.out.println("Создаю коллекции");
        List<String> list = FileUtils.getContentLines(path, StandardCharsets.UTF_8);
        List<Map<String, String>> mapList = FileUtils.toMapList(list);
        System.out.println();

        //2 задание

        //Вывод строки под определенным номером
        System.out.println("Вывод строки под определенным номером:");
        System.out.println(FileUtils.getLine(list, 1));
        System.out.println(FileUtils.getLine(list, 0));
        System.out.println(FileUtils.getLine(list, 100));
        System.out.println();

        //Вывод студентов в том порядке, в котором они появились в файле (уникальные)
        System.out.println("Вывод уникальных студентов в порядке списка файла:");
        System.out.println(FileUtils.getUniqueStudents(mapList));
        System.out.println();

        //Вывод студентов (уникальных) отсортированных по ФИО+дата рождения
        System.out.println("Вывод уникальных студентов отсортированных по ФИО+ДР:");
        System.out.println(FileUtils.sortedByNameAndDate(mapList));
        System.out.println();

        //Вывод студентов (уникальных) определенного курса
        System.out.println("Вывод уникальных студентов определенного курса:");
        System.out.println(FileUtils.getStudentsByCourse(mapList, 3));
        System.out.println();

        //Вывод студентов по предмету
        System.out.println("Вывод студентов по предмету:");
        System.out.println(FileUtils.getStudentsByClass(mapList, "русский язык"));
        System.out.println();

    }
}
