package de.softwartechnik.lucifer.gui.swing.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.inject.Inject;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public final class LoginPanel extends JPanel {
  private JTextField tfUsername;
  private JPasswordField pfPassword;
  private JLabel lbUsername;
  private JLabel lbPassword;
  private JButton btnLogin;
  private JButton btnCancel;

  @Inject
  public LoginPanel() {
    setLayout(new GridBagLayout());
    GridBagConstraints cs = new GridBagConstraints();

    cs.fill = GridBagConstraints.HORIZONTAL;

    lbUsername = new JLabel("Username: ");
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
    cs.gridx = 0;
    cs.gridy = 1;
    cs.gridwidth = 1;
    add(lbPassword, cs);

    pfPassword = new JPasswordField(20);
    cs.gridx = 1;
    cs.gridy = 1;
    cs.gridwidth = 2;
    add(pfPassword, cs);
    setBorder(new LineBorder(Color.GRAY));

    btnLogin = new JButton("Login");
    btnCancel = new JButton("Cancel");
    JPanel bp = new JPanel();
    bp.add(btnLogin);
    bp.add(btnCancel);
    cs.gridx = 0;
    cs.gridy = 2;
    cs.gridwidth = 3;
    add(bp, cs);
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
}
