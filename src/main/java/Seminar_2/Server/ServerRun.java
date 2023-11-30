package Seminar_2.Server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerRun extends JFrame implements Listener{
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;
    JButton btnStart = new JButton("Start server");
    JButton btnStop = new JButton("Stop server");

//    Listener listener = new Listener() {
//        @Override
//        public void messageRes(String message) {
//            System.out.println(message);
//        }
//    };
    Server server = new Server(this);
    ServerRun(){

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Server");
        setResizable(false);


        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.start();
            }
        });
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.stop();
            }

        });
        setLayout(new GridLayout(1, 2));

        add(btnStart);
        add(btnStop);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ServerRun();
    }

    @Override
    public void messageRes(String message) {
        System.out.println(message);
    }
}
