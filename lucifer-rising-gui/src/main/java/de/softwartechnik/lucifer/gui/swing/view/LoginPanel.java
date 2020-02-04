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

public final class LoginPanel extends BackgroundPanel {
  private JTextField tfUsername;
  private JPasswordField pfPassword;
  private JLabel lbUsername;
  private JLabel lbPassword;
  private JButton btnLogin;
  private JButton btnCancel;
  private JButton btnRegister;

  public LoginPanel() {
    super("/scull_title_background.jpg");
    setLayout(new GridBagLayout());
    GridBagConstraints cs = new GridBagConstraints();

    cs.fill = GridBagConstraints.HORIZONTAL;

    lbUsername = new JLabel("Username: ");
    lbUsername.setForeground(Color.WHITE);
    cs.gridx = 0;
    cs.gridy = 0;
    cs.gridwidth = 1;
    add(lbUsername, cs);

    tfUsername = new JTextField(20);
    cs.gridx = 1;
    cs.gridy = 0;
    cs.gridwidth = 2;
    add(tfUsername, cs);

    lbPassword = new JLabel("Password: ");
    lbPassword.setForeground(Color.WHITE);
    cs.gridx = 0;
    cs.gridy = 1;
    cs.gridwidth = 1;
    add(lbPassword, cs);

    pfPassword = new JPasswordField(20);
    cs.gridx = 1;
    cs.gridy = 1;
    cs.gridwidth = 2;
    add(pfPassword, cs);

    btnLogin = new JButton("Login");
    btnCancel = new JButton("Cancel");
    JPanel bp = new JPanel();
    bp.add(btnLogin);
    bp.add(btnCancel);
    cs.gridx = 1;
    cs.gridy = 2;
    cs.gridwidth = 2;
    add(bp, cs);

    btnRegister = new JButton("Noch kein Account?");
    btnRegister.setForeground(Color.WHITE);
    btnRegister.setBorderPainted(false);
    btnRegister.setContentAreaFilled(false);
    cs.gridx = 1;
    cs.gridy = 3;
    cs.gridwidth = 2;
    add(btnRegister, cs);
  }

  public String getUsername() {
    return tfUsername.getText().trim();
  }

  public String getPassword() {
    return new String(pfPassword.getPassword());
  }

  public JButton getBtnLogin() {
    return btnLogin;
  }

  public JButton getBtnCancel() {
    return btnCancel;
  }

  public JButton getBtnRegister() {
    return btnRegister;
  }
}
