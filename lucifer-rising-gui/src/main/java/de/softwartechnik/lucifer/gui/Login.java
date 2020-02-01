package de.softwartechnik.lucifer.gui;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login {

  private JTextField usernametextfield;
  private JPanel loginpanel;
  private JPasswordField passwordtextfield;
  private JLabel username;
  private JLabel password;
  private JButton loginbutton;
  private JLabel registerlabel;
  private JLabel loginfailed;
  private JFrame frame = new JFrame();

  void guiLogin() {
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 500);

    frame.setContentPane(loginpanel);

    usernametextfield.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
          login();
        }
      }
    });

    passwordtextfield.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
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

    registerlabel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseEntered(MouseEvent e) {
        registerlabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      }
    });

    registerlabel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        Signup s = new Signup();

        s.guiSignup(frame);
        frame.setVisible(false);
      }
    });

    frame.setVisible(true);
  }

  void login() {

    String passwort = String.valueOf(passwordtextfield.getPassword());
    String username = usernametextfield.getText();
    if (username.equals("test") && passwort.equals("test")) {
      Scenarioselection s = new Scenarioselection();

      s.guiScenarioselection();
      frame.setVisible(false);
    } else {
      JOptionPane.showMessageDialog(frame, "Benutzername oder Passwort ist flasch.");
    }
  }
}
