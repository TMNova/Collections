package ru.lanit;

import ru.lanit.utils.file.FileListUtils;
import ru.lanit.utils.file.FileUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class CollectionsCompare {
    final static String PATH_FOR_LINKED_LIST = "src/main/resources/students_for_LinkedList.txt";

    private static List<String> arrayList = new ArrayList<>();
    private static List<String> linkedList = new LinkedList<>();
    
    private static String[] stringArray;

    private static FileUtils fileUtils = new FileListUtils();

    public static void show(String path) throws IOException {
        System.out.println("Начинаем сравнение LinkedList:");
        System.out.println("Создание и добавление в лист 700_000+ строк:");
        createAndAddingCompare(path);

        System.out.println("Добавление 10000 элементов в начало списка");
        addingInFirstIndexOfList();
        System.out.println();

        System.out.println("Получение элемента по индексу");
        getElementsByIndex();
        System.out.println();

        System.out.println("Наглядное применение LinkedList для списка\n" 
                + "добавляем студентов из списка students_for_LinkedList.txt в начало листов");
        addStudentsFromAnotherFile(fileUtils.getContentLinesFromFile(PATH_FOR_LINKED_LIST, UTF_8));
        

    }
    
    private static void createStringArray(String path) throws IOException {
        stringArray = new String[fileUtils.getContentLinesFromFile(path, UTF_8).size()];
        fileUtils.getContentLinesFromFile(path, UTF_8).toArray(stringArray);
    }

    private static void createAndAddingCompare(String path) throws IOException {
        createStringArray(path);

        long startCreateArrayList = System.currentTimeMillis();
        arrayList.addAll(Arrays.asList(stringArray));
        long endCreateArrayList = System.currentTimeMillis();
        timer(startCreateArrayList, endCreateArrayList, "ArrayList");
        
        long startCreateLinkedList = System.currentTimeMillis();
        linkedList.addAll(Arrays.asList(stringArray));
        long endCreateLinkedList = System.currentTimeMillis();
        timer(startCreateLinkedList, endCreateLinkedList, "LinkedList");
        
    }

    private static void addingInFirstIndexOfList() throws IOException {

        long startAddingInMiddleArrayList = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(0, String.valueOf(i));
        }
        long endAddingInMiddleArrayList = System.currentTimeMillis();
        timer(startAddingInMiddleArrayList, endAddingInMiddleArrayList, "ArrayList");

        long startAddingInMiddleLinkedList = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            linkedList.add(0, String.valueOf(i));
        }
        long endAddingInMiddleLinkedList = System.currentTimeMillis();
        timer(startAddingInMiddleLinkedList, endAddingInMiddleLinkedList, "LinkedList");

    }
    
    private static void getElementsByIndex() throws IOException {
        long startGetElementArrayList = System.currentTimeMillis();
        for(int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i);
        }
        long endGetElementArraylist = System.currentTimeMillis();
        timer(startGetElementArrayList, endGetElementArraylist, "ArrayList");
        
        long startGetElementLinkedList = System.currentTimeMillis();
        for(int i = 0; i < linkedList.size(); i++) {
            linkedList.get(i);
        }
        long endGetElementLinkedList = System.currentTimeMillis();
        timer(startGetElementLinkedList, endGetElementLinkedList, "LinkedList");
        
    }
    
    private static void addStudentsFromAnotherFile(List<String> list) throws IOException {

        long startDeleteLinkedList = System.currentTimeMillis();
        for (String string : list) {
            linkedList.add(0, string);
        }
        long endDeleteLinkedList = System.currentTimeMillis();
        timer(startDeleteLinkedList, endDeleteLinkedList, "LinkedList");
        
        long startDeleteArrayList = System.currentTimeMillis();
        for (String string : list) {
            arrayList.add(0, string);
        }        long endDeleteArrayList = System.currentTimeMillis();
        timer(startDeleteArrayList, endDeleteArrayList, "ArrayList");
        
    }

    private static void timer(long start, long end, String description) throws IOException {
        System.out.println(end - start + "ms : " + description);
    }
}
