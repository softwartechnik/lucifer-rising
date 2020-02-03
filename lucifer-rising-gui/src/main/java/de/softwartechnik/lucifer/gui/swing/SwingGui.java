package de.softwartechnik.lucifer.gui.swing;

import de.softwartechnik.lucifer.gui.swing.client.Messaging;
import de.softwartechnik.lucifer.gui.swing.controller.Controller;
import de.softwartechnik.lucifer.gui.swing.view.*;

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
    SwingGui gui = new SwingGui(new Controller(
      new MainFrame(),
      new LoginView(new LoginPanel()),
      new MenuView(new MenuPanel()),
      new ScenarioView(new ScenarioPanel()),
      new SignUpView(new SignUpPanel()),
      Messaging.createMessagingWithJmsConnections()
    ));
    gui.initialize();
  }
}
