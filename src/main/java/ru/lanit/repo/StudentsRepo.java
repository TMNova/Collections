package ru.lanit.repo;

import java.util.*;

public class StudentsRepo implements Repository {

    public String getLine(List<String> list, int lineNumber) {
        int listLength = list.size();
        if (lineNumber > listLength || lineNumber < 1) return "Line " + lineNumber + " is not found.";

        return list.get(lineNumber - 1);
    }

    public List<String> getUniqueStudents(List<Map<String, String>> mapList) {
        List<String> stringList = new ArrayList<>();

        for (Map<String, String> map : mapList) {
            if (stringList.size() > 0
                    && isAvailableName(stringList, map.get("Name"))) {
                stringList.add(map.get("Name"));
            } else if (stringList.size() == 0) {
                stringList.add(map.get("Name"));
            }
        }
        return stringList;
    }

    public Set<String> sortedByNameAndDate(List<Map<String, String>> mapList) {
        Set<String> stringSet = new TreeSet<>();
        for (Map map : mapList) {
            stringSet.add(map.get("Name") + " - " + map.get("Date"));
        }
        return stringSet;
    }

    public Set<String> getStudentsByCourse(List<Map<String, String>> mapList, int courseNumber) {
        Set<String> stringSet = new HashSet<>();
        for(Map map : mapList) {
            int course = Integer.parseInt((String) map.get("Course"));
            if (course == courseNumber) stringSet.add(map.get("Name") + " - "
                    + map.get("Course"));
        }
        return stringSet;
    }

    public List<String> getStudentsByClass(List<Map<String, String>> mapList, String nameClass) {
        List<String> list = new ArrayList<>();
        for(Map map : mapList) {
            String stringClass = (String) map.get("Class");
            if (stringClass.equals(nameClass)) list.add((String) map.get("Name"));
        }
        return list;
    }

    public boolean isAvailableName(List<String> list, String name) {
        for (String string : list) {
            if (string.equals(name)) return false;
        }
        return true;
    }
}
