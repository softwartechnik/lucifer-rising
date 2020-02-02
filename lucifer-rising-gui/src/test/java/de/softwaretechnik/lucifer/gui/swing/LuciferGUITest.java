package de.softwaretechnik.lucifer.gui.swing;

import de.softwartechnik.lucifer.gui.swing.LuciferSwingGUI;
import de.softwartechnik.lucifer.gui.swing.controller.LuciferGUIController;
import de.softwartechnik.lucifer.gui.swing.view.LoginView;
import de.softwartechnik.lucifer.gui.swing.view.MainView;
import de.softwartechnik.lucifer.gui.swing.view.login.LoginPanel;
import org.junit.jupiter.api.Test;

public class LuciferGUITest {

  @Test
  void crappyAlibiTestForLookLook(){
    LuciferSwingGUI gui = new LuciferSwingGUI(new LuciferGUIController(new MainView(), new LoginView(new LoginPanel())));
    gui.initialize();
  }
}
