package Lecture.Lesson_4;

import java.util.*;

/**
 * Создайте коллекцию мужских и женских имен с помощью интерфейса List - добавьте повторяющиеся значения
 * Получите уникальный список Set на основании List
 * Определите наименьший элемент (алфавитный порядок)
 * Определите наибольший элемент (по количеству букв в слове но в обратном порядке)
 * Удалите все элементы содержащие букву ‘A’
 */
public class Task_2 {
    public static void main(String[] args) {
        ArrayList<String> peopleNames = new ArrayList<>();

        peopleNames.add("Александр");
        peopleNames.add("Мария");
        peopleNames.add("Денис");
        peopleNames.add("Юля");
        peopleNames.add("Михаил");
        peopleNames.add("Олег");
        peopleNames.add("Александр");
        peopleNames.add("Агностий");
        peopleNames.add("Мария");
        peopleNames.add("Денис");
        peopleNames.add("Юля");
        peopleNames.add("Михаил");
        peopleNames.add("Олег");
        peopleNames.add("Елена");
        peopleNames.add("Матвей");
        System.out.println(peopleNames);
        Set<String> uniqNames = new HashSet<>(peopleNames);
        System.out.println(uniqNames);
        String minName = uniqNames.stream().sorted().toList().get(0);
        System.out.println(minName);
        String maxName = uniqNames.stream().max(Comparator.comparingInt(String::length)).get();
        System.out.println(maxName);
        System.out.println(new StringBuilder(maxName).reverse());
        Iterator<String> iter = peopleNames.iterator();
        while (iter.hasNext()){
            String name = iter.next();
            if(name.contains("а")) {
                iter.remove();
            }
        }
        System.out.println(peopleNames);
        peopleNames.removeIf(currentName->currentName.contains("о"));
        System.out.println(peopleNames);

    }
}