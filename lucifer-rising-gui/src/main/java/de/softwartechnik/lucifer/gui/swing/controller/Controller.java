package de.softwartechnik.lucifer.gui.swing.controller;

import de.softwartechnik.lucifer.gui.swing.client.Messaging;
import de.softwartechnik.lucifer.gui.swing.view.LoginPanel;
import de.softwartechnik.lucifer.gui.swing.view.LoginView;
import de.softwartechnik.lucifer.gui.swing.view.MainFrame;
import de.softwartechnik.lucifer.gui.swing.view.MenuPanel;
import de.softwartechnik.lucifer.gui.swing.view.MenuView;
import de.softwartechnik.lucifer.gui.swing.view.ScenarioPanel;
import de.softwartechnik.lucifer.gui.swing.view.ScenarioView;
import de.softwartechnik.lucifer.gui.swing.view.SignUpPanel;
import de.softwartechnik.lucifer.gui.swing.view.SignUpView;

public final class Controller {

  private final MainFrame mainFrame;
  private final LoginView loginView;
  private final MenuView menuView;
  private final ScenarioView scenarioView;
  private final SignUpView signUpView;

  private final Messaging messaging;

  private String userId;
  private String sessionId;

  public Controller(
    MainFrame mainFrame,
    LoginView loginView,
    MenuView menuView,
    ScenarioView scenarioView,
    SignUpView signUpView,
    Messaging messaging
  ) {
    this.mainFrame = mainFrame;
    this.loginView = loginView;
    this.menuView = menuView;
    this.scenarioView = scenarioView;
    this.signUpView = signUpView;
    this.messaging = messaging;
  }

  public void showLogin() {
    mainFrame.setView(loginView);
  }

  public void setUpListener() {
    var loginPanel = (LoginPanel) loginView.getComponent();
    var menuPanel = (MenuPanel) menuView.getComponent();
    var signUpPanel = (SignUpPanel) signUpView.getComponent();

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

    signUpView.setActionListener(click -> {
      switch (click.getActionCommand()) {
        case "Registrieren":
          String surname = signUpPanel.getSurname();
          String name = signUpPanel.getName();
          String username = signUpPanel.getUsername();
          String email = signUpPanel.getEmail();
          String password = signUpPanel.getPassword();
          // TODO register using data
          break;
        case "Cancel":
          break;
      }
      mainFrame.setView(loginView);
    });

    menuView.setActionListener(click -> {
      switch (click.getActionCommand()) {
        case "Zombie Outbreak spielen":
          // TODO
          mainFrame.setView(scenarioView);
          break;
        case "Apokalypse spielen":
          // TODO
          mainFrame.setView(scenarioView);
          break;
        case "Logout":
          mainFrame.setView(loginView);
      }
    });

    scenarioView.setActionListener(click -> {
      switch (click.getActionCommand()) {
        case "Senden":
          String text = ((ScenarioPanel)scenarioView.getComponent())
              .getTextField()
              .getText();
          if (!text.isEmpty()) {
            messaging.sendMessage(userId, sessionId, text);

            scenarioView.addTextToUserArea(text + "\n");
            scenarioView.clearTextField();
            scenarioView.addTextToLuciferArea(
              "Antwort von Lucifer"
                + '\n'
            );
          }
          break;
        case "Speichern und verlassen":
          // TODO save game
          ((ScenarioPanel)scenarioView.getComponent()).getTextAreaLucifer().setText("");
          ((ScenarioPanel)scenarioView.getComponent()).getTextAreaUser().setText("");
          mainFrame.setView(menuView);
          break;
      }
    });
  }
}
