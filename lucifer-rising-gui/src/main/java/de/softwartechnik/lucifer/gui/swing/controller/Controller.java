package de.softwartechnik.lucifer.gui.swing.controller;

import de.softwartechnik.lucifer.gui.swing.client.GameClient;
import de.softwartechnik.lucifer.gui.swing.client.GameClient.Answer;
import de.softwartechnik.lucifer.gui.swing.client.UserClient;
import de.softwartechnik.lucifer.gui.swing.view.LoginPanel;
import de.softwartechnik.lucifer.gui.swing.view.LoginView;
import de.softwartechnik.lucifer.gui.swing.view.MainFrame;
import de.softwartechnik.lucifer.gui.swing.view.MenuPanel;
import de.softwartechnik.lucifer.gui.swing.view.MenuView;
import de.softwartechnik.lucifer.gui.swing.view.ScenarioPanel;
import de.softwartechnik.lucifer.gui.swing.view.ScenarioView;
import de.softwartechnik.lucifer.gui.swing.view.SignUpPanel;
import de.softwartechnik.lucifer.gui.swing.view.SignUpView;
import de.softwartechnik.lucifer.user.User;

public final class Controller {

  private final MainFrame mainFrame;
  private final LoginView loginView;
  private final MenuView menuView;
  private final ScenarioView scenarioView;
  private final SignUpView signUpView;

  private final GameClient gameClient;
  private final UserClient userClient;

  private User user;
  private String sessionId;

  public Controller(
    MainFrame mainFrame,
    LoginView loginView,
    MenuView menuView,
    ScenarioView scenarioView,
    SignUpView signUpView,
    GameClient gameClient,
    UserClient userClient
  ) {
    this.mainFrame = mainFrame;
    this.loginView = loginView;
    this.menuView = menuView;
    this.scenarioView = scenarioView;
    this.signUpView = signUpView;
    this.gameClient = gameClient;
    this.userClient = userClient;
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
          user = userClient.login(loginPanel.getUsername(), loginPanel.getPassword());
          if (user != null) {
            mainFrame.setView(menuView);
            menuPanel.setUserStatistics(user.getGamesPlayed(), user.getGamesWon());
            // TODO getGameStatistics
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
          userClient.register(signUpPanel.getUsername(), signUpPanel.getPassword());
          break;
        case "Cancel":
          break;
      }
      mainFrame.setView(loginView);
    });

    menuView.setActionListener(click -> {
      switch (click.getActionCommand()) {
        case "Zombie Outbreak spielen":
          gameClient.createGame(Integer.toString(user.getId()), "zombies");
          // TODO set sessionId
          mainFrame.setView(scenarioView);

          if (sessionId == null) {
            sessionId = gameClient.createGame("1", "zombies");
          }

          break;
        case "Apokalypse spielen":
          gameClient.createGame(Integer.toString(user.getId()), "apocalypse");
          mainFrame.setView(scenarioView);

          if (sessionId == null) {
            sessionId = gameClient.createGame("1", "apocalypse");
          }
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
            Answer answer = gameClient.sendMessage(sessionId, text);
            scenarioView.addTextToUserArea(text + "\n");
            scenarioView.clearTextField();
            scenarioView.addTextToLuciferArea(
              "Antwort von Lucifer"
                + String.join("\n", answer.messages())
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
