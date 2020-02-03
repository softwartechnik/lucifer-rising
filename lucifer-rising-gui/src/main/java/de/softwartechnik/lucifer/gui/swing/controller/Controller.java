package de.softwartechnik.lucifer.gui.swing.controller;

import de.softwartechnik.lucifer.gui.swing.view.*;

public final class Controller {

  private final MainFrame mainFrame;
  private final LoginView loginView;
  private final MenuView menuView;
  private final ScenarioView scenarioView;
  private final SignUpView signUpView;

  // private final Messaging messaging;

  public Controller(
    MainFrame mainFrame,
    LoginView loginView,
    MenuView menuView,
    ScenarioView scenarioView,
    SignUpView signUpView) {
    //, Messaging messaging) {
    this.mainFrame = mainFrame;
    this.loginView = loginView;
    this.menuView = menuView;
    this.scenarioView = scenarioView;
    this.signUpView = signUpView;
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
          loginPanel.getUsername();
          loginPanel.getPassword();
          if (true) { // TODO test credentials
            mainFrame.setView(menuView);
            menuPanel.setUserStatistics(42, 0);
            menuPanel.setGameStatistics(99, 16);
          }
          break;
        case "Cancel":
          mainFrame.dispose();
          break;
        case "Noch keinen Account?":
          mainFrame.setView(signUpView);
          break;
      }
    });

    menuView.setActionListener(click -> {
      switch (click.getActionCommand()) {
        case "Zombie Outbreak spielen!":
          // TODO
          break;
        case "Apokalyse spielen":
          // TODO
          break;
      }
      mainFrame.setView(scenarioView);
    });

    signUpView.setActionListener(click -> {
      mainFrame.setView(loginView);
    });
  }
}
