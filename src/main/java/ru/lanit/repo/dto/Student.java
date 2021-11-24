package ru.lanit.repo.dto;

import java.util.Objects;

public class Student {

    private String name;
    private String gender;
    private String birthday;
    private int courseNumber;
    private String lesson;

    public Student(String name, String gender, String birthday, int courseNumber, String lesson) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.courseNumber = courseNumber;
        this.lesson = lesson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return courseNumber == student.courseNumber
                && Objects.equals(name, student.name)
                && Objects.equals(gender, student.gender)
                && Objects.equals(birthday, student.birthday)
                && Objects.equals(lesson, student.lesson);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, birthday, courseNumber, lesson);
    }
}
