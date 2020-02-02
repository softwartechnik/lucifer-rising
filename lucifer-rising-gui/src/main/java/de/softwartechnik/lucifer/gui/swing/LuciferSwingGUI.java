package de.softwartechnik.lucifer.gui.swing;

import de.softwartechnik.lucifer.gui.swing.controller.LuciferGUIController;

import javax.inject.Inject;

public class LuciferSwingGUI {

  private final LuciferGUIController controller;

  @Inject
  public LuciferSwingGUI(LuciferGUIController controller) {
    this.controller = controller;
  }

  public void initialize() {
    controller.setUpListener();
    controller.showLogin();
  }
}
