package Lecture.Lesson_3;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.InputStream;

public class Task_1<T extends Comparable,V extends InputStream & DataInput,K extends Number>{
    /*
    Создать обобщенный класс с тремя параметрами (T, V, K). Класс содержит три переменные типа (T, V, K), конструктор,
    принимающий на вход параметры типа (T, V, K), методы возвращающие значения трех переменных. Создать метод, выводящий
    на консоль имена классов для трех переменных класса. Наложить ограничения на параметры типа: T должен реализовать
    интерфейс Comparable (классы оболочки, String), V должен реализовать интерфейс DataInput и расширять класс InputStream,
    K должен расширять класс Number
     */
    private T tValue;
    private V vValue;
    private K kValue;
    Task_1(T tValue, V vValue, K kValue){
        this.tValue = tValue;
        this.vValue = vValue;
        this.kValue = kValue;
    }

    public T gettValue() {
        return tValue;
    }

    public V getvValue() {
        return vValue;
    }

    public K getkValue() {
        return kValue;
    }

    public void getClassNames(){
        System.out.println(tValue.getClass().getSimpleName());
        System.out.println(vValue.getClass().getSimpleName());
        System.out.println(kValue.getClass().getSimpleName());

    }

    public static void main(String[] args) {
        String str = "abba";
        DataInputStream dis = new DataInputStream(System.in);
        Integer k = 5;
        Task_1<Comparable,DataInputStream,Number> object  = new Task_1<>(str,dis,k);
        object.getClassNames();
    }

}