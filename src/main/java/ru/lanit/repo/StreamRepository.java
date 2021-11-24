package ru.lanit.repo;

import ru.lanit.repo.dto.Student;

import java.util.List;

public interface StreamRepository {

    public String getLine(List<String> list, int lineNumber);

    public List<String> getUniqueStudents(List<Student> list);

    public List<String> sortedByNameAndDate(List<Student> list);

    public List<String> getStudentsByCourse(List<Student> mapList, int courseNumber);

    public List<String> getStudentsByClass(List<Student> mapList, String nameClass);

}
