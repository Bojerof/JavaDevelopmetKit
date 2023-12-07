package Seminar_2.Developer;

public class FrontEnd extends Developer implements FrontEndAction{
    @Override
    public void front() {
        System.out.println("Front Action");
    }

    @Override
    public void developerGUI(){
        System.out.println("FrontEnder GUI method");
    }
}
