package de.softwartechnik.lucifer.gui.swing.controller;

import de.softwartechnik.lucifer.gui.swing.view.LoginPanel;
import de.softwartechnik.lucifer.gui.swing.view.LoginView;
import de.softwartechnik.lucifer.gui.swing.view.MainFrame;
import de.softwartechnik.lucifer.gui.swing.view.MenuPanel;
import de.softwartechnik.lucifer.gui.swing.view.MenuView;
import de.softwartechnik.lucifer.gui.swing.view.ScenarioView;

public final class Controller {

  private final MainFrame mainFrame;
  private final LoginView loginView;
  private final MenuView menuView;
  private final ScenarioView scenarioView;

  // private final Messaging messaging;

  public Controller(
    MainFrame mainFrame,
    LoginView loginView,
    MenuView menuView,
    ScenarioView scenarioView) {
    //, Messaging messaging) {
    this.mainFrame = mainFrame;
    this.loginView = loginView;
    this.menuView = menuView;
    this.scenarioView = scenarioView;
    //this.messaging = messaging;
  }

  public void showLogin() {
    mainFrame.setView(loginView);
  }

  public void setUpListener() {
    var loginPanel = (LoginPanel) loginView.getComponent();
    var menuPanel = (MenuPanel) menuView.getComponent();
    loginView.setActionListener(click -> {
      switch (click.getActionCommand()) {
        case "Login":
          // TODO: login or registrate if new user
          loginPanel.getUsername();
          loginPanel.getPassword();
          // TODO show MainView
          mainFrame.setView(menuView);
          menuPanel.setUserStatistics(42, 0);
          menuPanel.setGameStatistics(99, 16);
          break;
        case "Cancel":
          // TODO close application
          break;
      }
    });
  }
}
