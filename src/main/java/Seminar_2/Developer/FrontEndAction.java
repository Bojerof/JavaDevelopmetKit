package Seminar_2.Developer;

public interface FrontEndAction {
    void front();
    default void coffee(){
        System.out.println("Drink");
    }
}
