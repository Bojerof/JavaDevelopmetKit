package Lecture.Lesson_3;

import java.util.ArrayList;
import java.util.Iterator;

/*
– Описать собственную коллекцию – список на основе массива. Коллекция должна иметь
возможность хранить любые типы данных, иметь методы добавления и удаления элементов.
 */
public class MyList<E> implements Iterable<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private E[] array;
    private int size;
    Object[] initialArray = new Object[DEFAULT_CAPACITY];

    public MyList(E[] array) {
        this.array = array;
        size = array.length;
    }

    public MyList() {
        this.array = (E[]) initialArray;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public <T extends E> void addElement(T element) {
        if (size == array.length) {
            Object[] newArray = new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            newArray[size] = element;
            array = (E[]) newArray;
        } else {
            array[size] = element;
        }
        size++;
    }

    public void removeElement(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[size - 1] = null;
        size--;
    }

    public int getArrayLength() {
        return array.length;
    }

    public void printList() {
        for (E elem : array) {
            System.out.printf(elem.toString() + " ");
        }
        System.out.println();
    }
    @Override
    public Iterator<E> iterator() {
        return new MyListIterator();
    }

    class MyListIterator implements Iterator<E> {
        int index;

        public MyListIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public E next() {
            return array[index++];
        }
    }
    public static void main(String[] args) {
        Number[] numArray = new Number[3];
        numArray[0] = 1;
        numArray[1] = 2.0f;
        numArray[2] = 123234324324L;
        MyList<Number> myList = new MyList<>(numArray);
        System.out.println(myList.getArrayLength());
        myList.addElement(10);
        myList.addElement(2.5f);
        myList.addElement(24332432432432L);
        myList.addElement(numArray[0]);
        myList.addElement(numArray[1]);
        myList.addElement(numArray[2]);
        System.out.println(myList.getArrayLength());
        for (Number number:myList) {
            System.out.printf(number+ " ");
        }
        System.out.println();
        myList.removeElement(5);

        for (Number number:myList) {
            System.out.printf(number+ " ");
        }
        ArrayList<String> arr = new ArrayList<>();
    }
}