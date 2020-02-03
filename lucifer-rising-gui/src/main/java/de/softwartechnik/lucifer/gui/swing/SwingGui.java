package de.softwartechnik.lucifer.gui.swing;

import de.softwartechnik.lucifer.gui.swing.controller.Controller;
import de.softwartechnik.lucifer.gui.swing.view.*;

import javax.inject.Inject;

public final class SwingGui {

  private final Controller controller;

  @Inject
  public SwingGui(Controller controller) {
    this.controller = controller;
  }

  public void initialize() {
    controller.setUpListener();
    controller.showLogin();
  }

  public static void main(String[] args) {
    //TODO: fix this with Dependency injection
    SwingGui gui = new SwingGui(new Controller(
      new MainFrame(),
      new LoginView(new LoginPanel()),
      new MenuView(new MenuPanel()),
      new ScenarioView(new ScenarioPanel()),
      new SignUpView(new SignUpPanel())
    ));

    gui.initialize();
  }
}
