package de.softwartechnik.lucifer.gui.swing.view;

import de.softwartechnik.lucifer.gui.swing.view.login.LoginPanel;

import javax.inject.Inject;
import javax.swing.*;
import java.awt.event.ActionListener;

public class LoginView implements LuciferGUIView {

  private LoginPanel login;

  @Inject
  public LoginView(LoginPanel login) {
    this.login = login;
  }

  @Override
  public JComponent getComponent() {
    return login;
  }

  public void setLoginButtonListener(ActionListener actionListener) {
    JButton loginButton = login.getBtnLogin();
    loginButton.addActionListener(actionListener);
  }
}
