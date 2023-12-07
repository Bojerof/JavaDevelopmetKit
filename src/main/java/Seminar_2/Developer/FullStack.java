package Seminar_2.Developer;

public class FullStack extends Developer implements BackEndAction, FrontEndAction {

    @Override
    public void back() {}

    @Override
    public void front() {}

    @Override
    public void developerGUI(){
        System.out.println("FullStack GUI method");
    }
}
