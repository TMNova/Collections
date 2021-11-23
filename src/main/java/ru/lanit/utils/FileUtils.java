package ru.lanit.utils;


import java.io.*;
import java.nio.charset.Charset;
import java.util.*;

public class FileUtils {
    public static List<String> getContentLines(String path, Charset charset) throws IOException {
        List<String> list = new ArrayList<>();
        InputStream file = new FileInputStream(path);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file, charset));

        String line;

        while ((line = bufferedReader.readLine()) != null) {
            list.add(line);
        }
        
        file.close();
        bufferedReader.close();

        return list;
    }

    public static List<Map<String, String>> toMapList(List<String> list) {
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

    public static String getLine(List<String> list, int lineNumber) {
        int listLength = list.size();
        if (lineNumber > listLength || lineNumber < 1) return "Line " + lineNumber + " is not found.";

        return list.get(lineNumber - 1);
    }

    public static List<String> getUniqueStudents(List<Map<String, String>> mapList) {
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

    public static Set<String> sortedByNameAndDate(List<Map<String, String>> mapList) {
        Set<String> stringSet = new TreeSet<>();
        for (Map map : mapList) {
            stringSet.add(map.get("Name") + " - " + map.get("Date"));
        }
        return stringSet;
    }

    public static Set<String> getStudentsByCourse(List<Map<String, String>> mapList, int courseNumber) {
        Set<String> stringSet = new HashSet<>();
        for(Map map : mapList) {
            int course = Integer.parseInt((String) map.get("Course"));
            if (course == courseNumber) stringSet.add(map.get("Name") + " - "
                    + map.get("Course"));
        }
        return stringSet;
    }

    public static List<String> getStudentsByClass(List<Map<String, String>> mapList, String nameClass) {
        List<String> list = new ArrayList<>();
        for(Map map : mapList) {
            String stringClass = (String) map.get("Class");
            if (stringClass.equals(nameClass)) list.add((String) map.get("Name"));
        }
        return list;
    }

    public static boolean isAvailableName(List<String> list, String name) {
        for (String string : list) {
            if (string.equals(name)) return false;
        }
        return true;
    }
}
