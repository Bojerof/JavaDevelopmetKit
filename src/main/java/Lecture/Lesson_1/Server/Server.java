package Lecture.Lesson_1.Server;

public class Server {
    boolean isServerWorking;
    Listener listener;

    public Server(Listener listener) {
        this.listener = listener;
        isServerWorking = false;
    }

    public void start(){
        if (!isServerWorking) isServerWorking = true;
        listener.messageRes("Статус сервера: " + isServerWorking);
    }
    public void stop(){
        if (isServerWorking) isServerWorking = false;
        listener.messageRes("Статус сервера: " + isServerWorking);
    }

}
