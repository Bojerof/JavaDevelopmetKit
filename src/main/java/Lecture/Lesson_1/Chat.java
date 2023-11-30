package Lecture.Lesson_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.lang.reflect.Array;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;

public class Chat extends JFrame {
    private static final int WINDOW_HEIGHT = 755;
    private static final int WINDOW_WIDTH = 607;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;
    JButton btnSend = new JButton("Отправить");
    JButton btnHistory = new JButton("История отправлений");
    JLabel lbLogin = new JLabel("Login");
    JLabel lbPassword = new JLabel("Password");
    JLabel lbIp = new JLabel("Ip");
    JLabel lbMessage = new JLabel("Message");
    JTextArea areaHistory = new JTextArea();
    JScrollPane scroll = new JScrollPane (areaHistory);

    JTextField textFieldLogin = new JTextField();
    JTextField textFieldPassword = new JTextField();
    JTextField textFieldIp = new JTextField();
    JTextArea areaMessage = new JTextArea();
    JTextField textFieldMessage = new JTextField();
    JPanel panServer = new JPanel(new GridLayout(6, 2));
    JPanel panClient = new JPanel(new GridLayout(4, 1));
    JPanel panHistory = new JPanel(new GridLayout(2, 1));
    String login;
    String password;
    String Ip;
    String message;
    String fileName = "src/main/java/Lecture/Lesson_1/history.txt";

    Chat() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("ChatWindow");
        setResizable(false);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        panServer.add(lbLogin);
        panServer.add(textFieldLogin);
        panServer.add(lbPassword);
        panServer.add(textFieldPassword);
        panServer.add(lbIp);
        panServer.add(textFieldIp);


        panClient.add(lbMessage);
        panClient.add(textFieldMessage);
        panClient.add(areaMessage);
        panClient.add(btnSend);

        panHistory.add(btnHistory);
        panHistory.add(scroll);

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                message = textFieldLogin.getText() + ": " + textFieldMessage.getText() + "\n";
                areaMessage.append(message);
                saveMessage(message);
                System.out.println("Message output: " + message);
                textFieldMessage.setText("");
            }
        });
        btnHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> history = readHistory();
                for (var item : history) {
                    areaHistory.append(item);
                    areaHistory.append("\n");
                }
            }
        });

        setLayout(new GridLayout(3, 1));
        add(panServer);
        add(panClient);
        add(panHistory);
        setVisible(true);
    }

    void saveMessage(String message) {
        try (FileWriter fileWriter = new FileWriter(fileName, true)) {
            fileWriter.write(message);
            fileWriter.write("\n");
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    List<String> readHistory(){
        List<String> list = new ArrayList<>();
        try {
            File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
            BufferedReader bf = new BufferedReader(fileReader);
            String line = bf.readLine();
            if (line != null)
                list.add(line);
            while (line != null){
                line = bf.readLine();
                if (line != null)
                    list.add(line);
            }
            fileReader.close();
        } catch (FileNotFoundException ex){
            ex.printStackTrace();
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return list;

    }

    public static void main(String[] args) {
        new Chat();
    }
}
