package de.softwartechnik.lucifer.gui.swing;

import de.softwartechnik.lucifer.gui.swing.controller.Controller;

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
}
