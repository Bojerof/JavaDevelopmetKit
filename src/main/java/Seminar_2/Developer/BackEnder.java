package Seminar_2.Developer;

public class BackEnder extends Developer implements BackEndAction{
    @Override
    public void back() {
        System.out.println("Backend Action");
    }
}
