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
          // TODO: login or registrate if new user
          loginPanel.getUsername();
          loginPanel.getPassword();
          // TODO show MainView
          mainFrame.setView(menuView);
          //mainFrame.setView(scenarioView);
          menuPanel.setUserStatistics(42, 0);
          menuPanel.setGameStatistics(99, 16);
          break;
        case "Cancel":
          mainFrame.dispose();
          break;
        case "Noch keinen Account?":
          mainFrame.setView(signUpView);
          break;
      }
    });
    signUpView.setActionListener(click -> {
      mainFrame.setView(loginView);
    });
    scenarioView.setActionListener(click -> {
      switch (click.getActionCommand()) {
        case "Senden":
          // TODO send typed message in TextArea + generate response
          break;
        case "Speichern und verlassen":
          // TODO safe game and return
          break;
      }
    });
  }
}
