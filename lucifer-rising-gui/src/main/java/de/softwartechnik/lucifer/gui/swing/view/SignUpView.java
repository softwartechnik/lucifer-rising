package de.softwartechnik.lucifer.gui.swing.view;

import javax.inject.Inject;
import javax.swing.*;
import java.awt.event.ActionListener;

public class SignUpView implements View{

  private final SignUpPanel signUpPanel;

  @Inject
  public SignUpView(SignUpPanel signUpPanel) { this.signUpPanel = signUpPanel;}

  @Override
  public JComponent getComponent() { return signUpPanel; }

  public void setActionListener(ActionListener actionListener) {
    signUpPanel.getBtnCancel().addActionListener(actionListener);
    signUpPanel.getBtnRegister().addActionListener(actionListener);
  }
}
