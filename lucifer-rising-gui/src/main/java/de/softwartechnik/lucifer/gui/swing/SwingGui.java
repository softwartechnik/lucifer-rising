package de.softwartechnik.lucifer.gui.swing;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import de.softwartechnik.lucifer.gui.swing.client.GameClient;
import de.softwartechnik.lucifer.gui.swing.client.UserClient;
import de.softwartechnik.lucifer.gui.swing.controller.Controller;
import de.softwartechnik.lucifer.gui.swing.view.LoginPanel;
import de.softwartechnik.lucifer.gui.swing.view.LoginView;
import de.softwartechnik.lucifer.gui.swing.view.MainFrame;
import de.softwartechnik.lucifer.gui.swing.view.MenuPanel;
import de.softwartechnik.lucifer.gui.swing.view.MenuView;
import de.softwartechnik.lucifer.gui.swing.view.ScenarioPanel;
import de.softwartechnik.lucifer.gui.swing.view.ScenarioView;
import de.softwartechnik.lucifer.gui.swing.view.SignUpPanel;
import de.softwartechnik.lucifer.gui.swing.view.SignUpView;

public final class SwingGui {

  private final Controller controller;

  public SwingGui(Controller controller) {
    this.controller = controller;
  }

  public void initialize() {
    controller.setUpListener();
    controller.showLogin();
  }

  public static void main(String[] args) {
    try {
      boolean nimbus = false;

      for(LookAndFeelInfo lai : UIManager.getInstalledLookAndFeels()) {
        if(lai.getClassName().toLowerCase().contains("nimbus")) {
          UIManager.setLookAndFeel(lai.getClassName());
          nimbus = true;
          break;
        }
      }

      if(!nimbus) UIManager.setLookAndFeel(
        UIManager.getSystemLookAndFeelClassName());
    } catch(Exception e) {/* ignored */}

    SwingGui gui = new SwingGui(new Controller(
      new MainFrame(),
      new LoginView(new LoginPanel()),
      new MenuView(new MenuPanel()),
      new ScenarioView(new ScenarioPanel()),
      new SignUpView(new SignUpPanel()),
      GameClient.create(),
      UserClient.create()
    ));
    gui.initialize();
  }
}
