package de.softwartechnik.lucifer.gui.swing.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public final class SignUpPanel extends BackgroundPanel {
  private JTextField username;
  private JPasswordField pfPassword;
  private JPasswordField pfPasswordRepeat;
  private JLabel lbUsername;
  private JLabel lbPwd;
  private JLabel lbPwdRepeat;

  private JButton btnCancel;
  private JButton btnRegister;

  public SignUpPanel() {
    super("/scull_title_background.jpg");
    setLayout(new GridBagLayout());
    GridBagConstraints cs = new GridBagConstraints();

    cs.fill = GridBagConstraints.HORIZONTAL;

    lbUsername = new JLabel("Username: ");
    cs.gridx = 0;
    cs.gridy = 0;
    cs.gridwidth = 1;
    add(lbUsername, cs);

    username = new JTextField(20);
    cs.gridx = 1;
    cs.gridy = 0;
    cs.gridwidth = 2;
    add(username, cs);

    lbPwd = new JLabel("Password: ");
    cs.gridx = 0;
    cs.gridy = 1;
    cs.gridwidth = 1;
    add(lbPwd, cs);

    pfPassword = new JPasswordField(20);
    cs.gridx = 1;
    cs.gridy = 1;
    cs.gridwidth = 2;
    add(pfPassword, cs);
    setBorder(new LineBorder(Color.GRAY));

    lbPwdRepeat = new JLabel("Passwort wiederholen: ");
    cs.gridx = 0;
    cs.gridy = 2;
    cs.gridwidth = 1;
    add(lbPwdRepeat, cs);

    pfPasswordRepeat = new JPasswordField(20);
    cs.gridx = 1;
    cs.gridy = 2;
    cs.gridwidth = 2;
    add(pfPasswordRepeat, cs);
    setBorder(new LineBorder(Color.GRAY));

    btnRegister = new JButton("Registrieren");
    btnCancel = new JButton("Cancel");
    JPanel bp = new JPanel();
    bp.add(btnRegister);
    bp.add(btnCancel);
    cs.gridx = 1;
    cs.gridy = 3;
    cs.gridwidth = 2;
    add(bp, cs);
  }

  public String getUsername() {
    return username.getText();
  }

  public String getPassword() {
    return pfPassword.getText();
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
