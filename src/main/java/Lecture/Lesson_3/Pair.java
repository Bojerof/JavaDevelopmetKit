package Lecture.Lesson_3;

public class Pair<E, T> {
    private E valueE;
    private T valueT;

    public Pair(E valueE, T valueT) {
        this.valueE = valueE;
        this.valueT = valueT;
    }

    @Override
    public String toString() {
        return "Pair{" + "Class: " +
                valueE.getClass().getSimpleName() +
                " value:  " + valueE +
                " Class: " + valueT.getClass().getSimpleName() +
                " value:  " + valueT + '}';
    }

    public E getValueE() {
        return valueE;
    }

    public T getValueT() {
        return valueT;
    }

    public static void main(String[] args) {
        Pair<Integer,Double> pair1 = new Pair<>(1,0.2323);
        Pair<String,Double> pair2 = new Pair<>("Hello, World!",12321.32432432);
        Pair<String,Boolean> pair3 = new Pair<>("Hello, World!",true);

        System.out.println(pair1.getValueE());
        System.out.println(pair1.getValueT());
        System.out.println(pair1.toString());

        System.out.println(pair2.getValueE());
        System.out.println(pair2.getValueT());
        System.out.println(pair2.toString());

        System.out.println(pair3.getValueE());
        System.out.println(pair3.getValueT());
        System.out.println(pair3.toString());


    }
}