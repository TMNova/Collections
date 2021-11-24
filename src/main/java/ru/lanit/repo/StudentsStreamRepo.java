package ru.lanit.repo;

import ru.lanit.repo.dto.Student;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentsStreamRepo implements StreamRepository {

    @Override
    public String getLine(List<String> list, int lineNumber) {
        return list.get(lineNumber);
    }

    @Override
    public List<String> getUniqueStudents(List<Student> list) {
        List<String> lines = list.stream()
                .map(Student::getName)
                .distinct()
                .collect(Collectors.toList());
        return lines;
    }

    @Override
    public List<String> sortedByNameAndDate(List<Student> list) {
        Comparator<Student> comparator = Comparator.comparing(Student::getName);
        comparator = comparator.thenComparing(Comparator.comparing(Student::getBirthday));

        List<String> lines = list.stream()
                .sorted(comparator)
                .map(student -> String.format("%s - %s", student.getName(), student.getBirthday()))
                .distinct()
                .collect(Collectors.toList());

        return lines;
    }

    @Override
    public List<String> getStudentsByCourse(List<Student> list, int courseNumber) {
        List<String> lines = list.stream()
                .filter(student -> student.getCourseNumber() == courseNumber)
                .map(Student::getName)
                .distinct()
                .collect(Collectors.toList());

        return lines;
    }

    @Override
    public List<String> getStudentsByClass(List<Student> mapList, String nameClass) {
        List<String> lines = mapList.stream()
                .filter(student -> student.getLesson().equals(nameClass))
                .map(Student::getName)
                .distinct()
                .collect(Collectors.toList());

        return lines;
    }

}
