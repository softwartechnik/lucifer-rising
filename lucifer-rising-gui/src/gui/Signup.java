package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup {
  private JPanel signuppanel;
  private JTextField firstnameTextField;
  private JTextField secondnameTextField;
  private JTextField emailTextField;
  private JPasswordField passwordField1;
  private JPasswordField passwordField2;
  private JButton signupbutton;
  private JButton cancelbutton;
  private JTextField usernameTextField;

  private JFrame frame = new JFrame();

  void guiSignup(JFrame loginframe) {
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(520, 650);

    frame.setContentPane(signuppanel);

    signupbutton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) { signup(); }
    });

    cancelbutton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        loginframe.setVisible(true);
        frame.setVisible(false);
      }
    });

    frame.setVisible(true);
  }

  void signup() {
    String firstname = firstnameTextField.getText();
    String secondname = secondnameTextField.getText();
    String username = usernameTextField.getText();
    String email = emailTextField.getText();
    String passwort1 = String.valueOf(passwordField1.getPassword());
    String passwort2 = String.valueOf(passwordField2.getPassword());

    if(firstname.equals("") || secondname.equals("") || username.equals("") || email.equals("") || passwort1.equals("") || passwort2.equals("")) {
      JOptionPane.showMessageDialog(frame, "Bitte füllen Sie alle Felder aus.");
    }
    else {
      if(passwort1.equals(passwort2)) {
        //Send data to Database
        System.out.println("firstname: " + firstname);
        System.out.println("secondname: " + secondname);
        System.out.println("username: " + username);
        System.out.println("email: " + email);
        System.out.println("passwort1: " + passwort1);
        System.out.println("passwort2: " + passwort2);
      }
      else {
        JOptionPane.showMessageDialog(frame, "Die Passwörter stimmen nicht überein.");
      }
    }

  }
}
