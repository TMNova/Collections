package ru.lanit.repo;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Repository {

    public String getLine(List<String> list, int lineNumber);

    public List<String> getUniqueStudents(List<Map<String, String>> mapList);

    public Set<String> sortedByNameAndDate(List<Map<String, String>> mapList);

    public Set<String> getStudentsByCourse(List<Map<String, String>> mapList, int courseNumber);

    public List<String> getStudentsByClass(List<Map<String, String>> mapList, String nameClass);

    public boolean isAvailableName(List<String> list, String name);
    
}
