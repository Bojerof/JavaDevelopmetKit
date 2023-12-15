package Lecture.Lesson_3;

public class Main {
    private static class Box {
        private Object obj;

        public Box(Object obj) {
            this.obj = obj;
        }

        public Object getObj() {
            return obj;
        }

        public void setObj(Object obj) {
            this.obj = obj;
        }

        public void printObj() {
            System.out.printf("Box (%s): %s)",
                    obj.getClass().getSimpleName(), obj.toString());
        }
    }

    public static void main(String[] args) {
        Box b1 = new Box(20);
        Box b2 = new Box(30);

    }
}