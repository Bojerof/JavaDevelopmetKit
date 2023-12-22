package Lecture.Lesson_4;

import java.util.*;

/**
 * В рамках выполнения задачи студентам необходимо:
 * Создайте коллекцию мужских и женских имен с помощью интерфейса List
 * Отсортируйте коллекцию в алфавитном порядке
 * Отсортируйте коллекцию по количеству букв в слове
 * Разверните коллекцию
 */
public class PeopleNames {
    private List<String> names;

    PeopleNames(){
        names = new ArrayList<>();
    }
    void addName(String name){
        names.add(name);
    }

    public static void main(String[] args) {
        ArrayList<String> peopleNames = new ArrayList<>();

        peopleNames.add("Александр");
        peopleNames.add("Мария");
        peopleNames.add("Денис");
        peopleNames.add("Юля");
        peopleNames.add("Михаил");
        peopleNames.add("Олег");
        System.out.println(peopleNames);
        Collections.sort(peopleNames);
        System.out.println(peopleNames);
        peopleNames.sort((s1,s2)->s1.length()-s2.length());

        peopleNames.sort(Comparator.comparingInt(String::length));
        System.out.println(peopleNames);
    }
}