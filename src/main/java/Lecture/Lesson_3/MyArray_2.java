package Lecture.Lesson_3;

public class MyArray_2<E> {
    private final int DEFAULTARRAYLENGTH = 4;
    private Object[] array;
    int size;

    public E getArray() {
        return (E)array;
    }

    public int getSize() {
        return size;
    }
    <E> void add(E elem) {
        if (array.length == size) {
            Object[] tmpArray = new Object[array.length * 2];
            System.arraycopy(array,0,tmpArray,0,array.length);
            tmpArray[size] = elem;
            array = tmpArray;

        } else {
            array[size] = elem;
        }
        size++;
    }
    <E> boolean  changeElement(int index1, int index2){
        if (index1 < 0 || index2 < 0 || index1 >= size || index2 >= size){
            return false;
        } else {
            E tmp = (E)array[index1];
            array[index1]=array[index2];
            array[index2] = tmp;
        }
        return true;
    }

}
