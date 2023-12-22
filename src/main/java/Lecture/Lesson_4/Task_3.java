package Lecture.Lesson_4;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

/**
 * Создайте телефонный справочник с помощью Map - телефон это ключ, а имя значение
 * Найдите человека с самым маленьким номером телефона
 * Найдите номер телефона человека чье имя самое большое в алфавитном порядке
 */
public class Task_3 {
    public static void main(String[] args) {
        Map<String,String> phoneBook = new HashMap<>();
        phoneBook.put("79101015953","Denis");
        phoneBook.put("9306715130","Artem");
        phoneBook.put("9200015230","Vasya");
        phoneBook.put("9220103041","Igor");
        phoneBook.put("9114384378","Vitya");
        phoneBook.put("9128739281","Arseniy");
//        String minPhone = phoneBook.keySet().stream().sorted().findFirst().get();
        String minPhone = phoneBook.keySet().stream().min(Comparator.comparingLong((s)->parseLong(s))).get();
        System.out.println(minPhone + " : " + phoneBook.get(minPhone));
        String maxValue = phoneBook.values().stream().sorted((s1,s2)->-s1.compareTo(s2)).findFirst().get();
        System.out.println(maxValue);
        System.out.println(phoneBook.entrySet().stream().filter((e)->e.getValue().equals(maxValue)).findAny().get().getKey());
    }

}
