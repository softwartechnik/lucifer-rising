package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login {

    private JTextField usernametextfield;
    private JPanel loginpanel;
    private JPasswordField passwordtextfield;
    private JLabel username;
    private JLabel password;
    private JButton loginbutton;
    private JLabel loginfailed;
    private JFrame frame = new JFrame();

    void guiLogin() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);

        frame.setContentPane(loginpanel);


        usernametextfield.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                {
                    login();
                }
            }
        });

        passwordtextfield.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                {
                    login();
                }
            }
        });

        loginbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                login();
            }
        });

        frame.setVisible(true);
    }

    void login(){

        String passwort = String.valueOf(passwordtextfield.getPassword());
        String username = usernametextfield.getText();
        if(username.equals("test") && passwort.equals("test")) {
            Scenario s = new Scenario();

            s.showscenario(username);
            frame.setVisible(false);
        }
        else{
            loginfailed.setVisible(true);
        }
    }
}
