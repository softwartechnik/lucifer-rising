package de.softwaretechnik.lucifer.gui.swing;

import de.softwartechnik.lucifer.gui.swing.SwingGui;
import de.softwartechnik.lucifer.gui.swing.controller.Controller;
import de.softwartechnik.lucifer.gui.swing.view.LoginPanel;
import de.softwartechnik.lucifer.gui.swing.view.LoginView;
import de.softwartechnik.lucifer.gui.swing.view.MainFrame;
import de.softwartechnik.lucifer.gui.swing.view.MenuPanel;
import de.softwartechnik.lucifer.gui.swing.view.MenuView;
import de.softwartechnik.lucifer.gui.swing.view.ScenarioPanel;
import de.softwartechnik.lucifer.gui.swing.view.ScenarioView;
import org.junit.jupiter.api.Test;

public class LuciferGUITest {

  @Test
  void crappyAlibiTestForLookLook() {
    SwingGui gui = new SwingGui(new Controller(
      new MainFrame(),
      new LoginView(new LoginPanel()),
      new MenuView(new MenuPanel()),
      new ScenarioView(new ScenarioPanel())
    ));
    // Messaging.createMessagingWithJmsConnections()));
    gui.initialize();
    //while (true) { }
  }
}
