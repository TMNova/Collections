package ru.lanit.utils;

import ru.lanit.repo.dto.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Converter {

    public static List<Map<String, String>> toStudentsMapList(List<String> list) {
        List<Map<String, String>> mapList = new ArrayList<>();
        for (String string : list) {
            String[] stringArray = string.split(", ");
            mapList.add(new HashMap<String, String>() {{
                put("Name", stringArray[0]);
                put("Gender", stringArray[1]);
                put("Date", stringArray[2]);
                put("Course", stringArray[3]);
                put("Class", stringArray[4]);
            }});
        }
        return mapList;
    }

    public static List<Student> toStudentList(List<String> list) {
        List<Student> listOfStudents = new ArrayList<>();

        for(String line : list) {
            String[] stringArray = line.split(", ");
            Student student = new Student(stringArray[0], stringArray[1], stringArray[2],
                    Integer.parseInt(stringArray[3]), stringArray[4]);
            listOfStudents.add(student);
        }

        return listOfStudents;
    }
}
