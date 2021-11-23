package ru.lanit;

import java.io.*;

public class Main {
    final static String PATH = "src/main/resources/students.txt";
    final static String PATH_FOR_LINKED_LIST = "src/main/resources/students_for_LinkedList.txt";

    public static void main(String[] args) throws IOException {
        //Основное задание связанное с сортировкой и выводом студентов

        StudentsInit.show(PATH);

/*      -------------------------------------------------------------------------------------------------
        LinkedList и его сравнение (по производительности) с ArrayList (создал для этого отдельный файл
        с более, чем 700_000+ студентами
        -------------------------------------------------------------------------------------------------       */

        CollectionsCompare.show(PATH_FOR_LINKED_LIST);

    }
}
