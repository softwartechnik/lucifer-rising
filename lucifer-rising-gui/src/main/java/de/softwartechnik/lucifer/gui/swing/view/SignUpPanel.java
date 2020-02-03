package de.softwartechnik.lucifer.gui.swing.view;

import javax.inject.Inject;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class SignUpPanel extends JPanel {
  private JTextField surname;
  private JTextField name;
  private JTextField username;
  private JTextField email;
  private JPasswordField pfPassword;
  private JPasswordField pfPasswordRepeat;
  private JLabel lbSurname;
  private JLabel lbName;
  private JLabel lbUsername;
  private JLabel lbMail;
  private JLabel lbPwd;
  private JLabel lbPwdRepeat;

  private JButton btnCancel;
  private JButton btnRegister;

  @Inject
  public SignUpPanel() {
    setLayout(new GridBagLayout());
    GridBagConstraints cs = new GridBagConstraints();

    cs.fill = GridBagConstraints.HORIZONTAL;

    lbSurname = new JLabel("Vorname: ");
    cs.gridx = 0;
    cs.gridy = 0;
    cs.gridwidth = 1;
    add(lbSurname, cs);

    surname = new JTextField(20);
    cs.gridx = 1;
    cs.gridy = 0;
    cs.gridwidth = 2;
    add(surname, cs);

    lbName = new JLabel("Name: ");
    cs.gridx = 0;
    cs.gridy = 1;
    cs.gridwidth = 1;
    add(lbName, cs);

    name = new JTextField(20);
    cs.gridx = 1;
    cs.gridy = 1;
    cs.gridwidth = 2;
    add(name, cs);

    lbUsername = new JLabel("Username: ");
    cs.gridx = 0;
    cs.gridy = 2;
    cs.gridwidth = 1;
    add(lbUsername, cs);

    username = new JTextField(20);
    cs.gridx = 1;
    cs.gridy = 2;
    cs.gridwidth = 2;
    add(username, cs);

    lbMail = new JLabel("EMail: ");
    cs.gridx = 0;
    cs.gridy = 3;
    cs.gridwidth = 1;
    add(lbMail, cs);

    email = new JTextField(20);
    cs.gridx = 1;
    cs.gridy = 3;
    cs.gridwidth = 2;
    add(email, cs);

    lbPwd = new JLabel("Password: ");
    cs.gridx = 0;
    cs.gridy = 4;
    cs.gridwidth = 1;
    add(lbPwd, cs);

    pfPassword = new JPasswordField(20);
    cs.gridx = 1;
    cs.gridy = 4;
    cs.gridwidth = 2;
    add(pfPassword, cs);
    setBorder(new LineBorder(Color.GRAY));

    lbPwdRepeat = new JLabel("Passwort wiederholen: ");
    cs.gridx = 0;
    cs.gridy = 5;
    cs.gridwidth = 1;
    add(lbPwdRepeat, cs);

    pfPasswordRepeat = new JPasswordField(20);
    cs.gridx = 1;
    cs.gridy = 5;
    cs.gridwidth = 2;
    add(pfPasswordRepeat, cs);
    setBorder(new LineBorder(Color.GRAY));

    btnRegister = new JButton("Registrieren");
    btnCancel = new JButton("Cancel");
    JPanel bp = new JPanel();
    bp.add(btnRegister);
    bp.add(btnCancel);
    cs.gridx = 0;
    cs.gridy = 6;
    cs.gridwidth = 3;
    add(bp, cs);
  }

  public JTextField getSurname() {
    return surname;
  }

  public JTextField getTheName() {
    return name;
  }

  public JTextField getUsername() {
    return username;
  }

  public JTextField getEmail() {
    return email;
  }

  public JPasswordField getPfPassword() {
    return pfPassword;
  }

  public JPasswordField getPfPasswordRepeat() {
    return pfPasswordRepeat;
  }

  public JButton getBtnCancel() {
    return btnCancel;
  }

  public JButton getBtnRegister() {
    return btnRegister;
  }
}
