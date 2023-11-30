package Lecture.Lesson_1.Game;

import Lecture.Lesson_1.Game.GameWindow;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 230;
    private static final int WINDOW_WIDTH = 350;
    JPanel panButton;
    JLabel gameMode = new JLabel("Выберите режим игры");
    JLabel gameField = new JLabel("Установленный размер поля");
    JLabel winCount = new JLabel("Установленная длина");
    JSlider fieldSlider = new JSlider(3, 10);
    JSlider winLengthSlider = new JSlider(3, 10);
    JButton btnStart = new JButton("Start new game");
    JRadioButton humanVsAi = new JRadioButton("Человек против компьютера");
    JRadioButton humanVsHuman = new JRadioButton("Человек против человека");
    ButtonGroup buttonGroup = new ButtonGroup();
    SettingWindow(GameWindow gameWindow){
        setLocationRelativeTo(gameWindow);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        panButton = new JPanel(new GridLayout(8, 1));
        buttonGroup.add(humanVsAi);
        buttonGroup.add(humanVsHuman);

        panButton.add(gameMode);
        panButton.add(humanVsAi);
        panButton.add(humanVsHuman);
        panButton.add(gameField);
        panButton.add(fieldSlider);
        panButton.add(winCount);
        panButton.add(winLengthSlider);
        humanVsAi.setSelected(true);
        fieldSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                gameField.setText("Установленный размер поля: " + fieldSlider.getValue());
            }
        });
        winLengthSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                winCount.setText("Установленная длина: " + winLengthSlider.getValue());
            }
        });

        panButton.add(btnStart);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameWindow.startNewGame(humanVsAi.isSelected() ? 0 : 1, fieldSlider.getValue(), fieldSlider.getValue(),
                        winLengthSlider.getValue());
                setVisible(false);
            }
        });
        add(panButton);
    }
}
