package de.softwaretechnik.lucifer.gui.swing;

import de.softwartechnik.lucifer.gui.swing.SwingGui;
import de.softwartechnik.lucifer.gui.swing.controller.Controller;
import de.softwartechnik.lucifer.gui.swing.view.*;
import org.junit.jupiter.api.Test;

public class LuciferGUITest {

  @Test
  void crappyAlibiTestForLookLook() {
    SwingGui gui = new SwingGui(new Controller(
      new MainFrame(),
      new LoginView(new LoginPanel()),
      new MenuView(new MenuPanel()),
      new ScenarioView(new ScenarioPanel()),
      new SignUpView(new SignUpPanel())
    ));
    // Messaging.createMessagingWithJmsConnections()));
    gui.initialize();
    while (true) { }
  }
}
