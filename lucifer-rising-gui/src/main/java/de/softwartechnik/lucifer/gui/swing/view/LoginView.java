package de.softwartechnik.lucifer.gui.swing.view;

import java.awt.event.ActionListener;
import javax.inject.Inject;
import javax.swing.JComponent;

public final class LoginView implements View {

  private final LoginPanel loginPanel;

  @Inject
  public LoginView(LoginPanel loginPanel) {
    this.loginPanel = loginPanel;
  }

  @Override
  public JComponent getComponent() {
    return loginPanel;
  }

  public void setActionListener(ActionListener actionListener) {
    loginPanel.getBtnLogin().addActionListener(actionListener);
    loginPanel.getBtnCancel().addActionListener(actionListener);
    loginPanel.getBtnRegister().addActionListener(actionListener);
  }
}
