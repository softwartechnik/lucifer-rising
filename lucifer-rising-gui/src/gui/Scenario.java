package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Scenario {
    private JTextField textField;
  private JButton sendbutton;
    private JTextArea receiveTextArea;
    private JTextArea sendTextArea;
    private JPanel scenariopanel;

    //scenarioseleted 1 Zombie Outbreak      2 Apokalypse
    void guiscenario (int scenarioseleted) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);

        frame.setContentPane(scenariopanel);

        sendTextArea.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        receiveTextArea.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                {
                    sendText();
                }
            }
        });

        sendbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                sendText();
            }
        });

        frame.setVisible(true);
    }

    void sendText() {
        sendTextArea.append(textField.getText() + "\n");
        receiveTextArea.append("\n");
        textField.setText("");
    }

    public void receiveText(String text) {
        receiveTextArea.append(text + "\n");
        sendTextArea.append("\n");
    }
}
