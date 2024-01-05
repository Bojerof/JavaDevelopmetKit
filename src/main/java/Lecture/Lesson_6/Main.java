package Lecture.Lesson_6;
import Lecture.Lesson_6.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        DescriptiveStatistics ds = new DescriptiveStatistics();
        ds.addValue(5);
        ds.addValue(4);
        ds.addValue(3);
        ds.addValue(3);
        System.out.println("Использовал внешнюю библиотеку commons.math3 которую использовали на семинаре.");
        System.out.print(ds.getMean() + " - среднее арифметическое.");
    }
}