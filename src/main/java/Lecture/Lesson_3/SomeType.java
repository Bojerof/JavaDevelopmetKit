package Lecture.Lesson_3;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class SomeType <T>{
    public <E> void test(Collection<E> collection) {
        for (E element : collection) {
            System.out.println(element);
        }
    }
    public void test(List<Integer> collection) {
        for (Integer element : collection) {
            System.out.println(element);
        }
    }
    public static void main(String []args) {
        SomeType<String> st = new SomeType<>();
        SomeType<Integer> st_2 = new SomeType<>();
        List<String> list = Arrays.asList("test");
        List<Integer> list_2 = Arrays.asList(5,2,5,7,2,6);
        st.test(list);
        st_2.test(list);
        st.test(list_2);
        st_2.test(list_2);
    }
}
