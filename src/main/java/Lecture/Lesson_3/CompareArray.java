package Lecture.Lesson_3;

public class CompareArray {
    public <E> boolean compareArray(E[] arrayA, E[] arrayB) {
        if (arrayA.length != arrayB.length) {
            return false;
        } else {
            for (int i = 0; i < arrayA.length; i++) {
                if (!arrayA[i].equals(arrayB[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}