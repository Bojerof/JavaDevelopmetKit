package Seminar_2.Developer;

import java.util.ArrayList;

public class Homework_2 {
    private static final ArrayList<Developer> developers = new ArrayList<>();
    public static void homework_2(){
        developers.add(new FrontEnd());
        developers.add(new BackEnder());
        developers.add(new FullStack());
        developers.add(new FrontEnd());

        for (int i = 0; i < developers.size(); i++) {
            if (developers.get(i) instanceof FrontEnd) (developers.get(i)).developerGUI();
        }
    }

    public static void main(String[] args) {
        homework_2();
    }
}
