package de.softwartechnik.lucifer.gui.swing.controller;

import de.softwartechnik.lucifer.gui.swing.view.LoginView;
import de.softwartechnik.lucifer.gui.swing.view.MainView;

import java.util.Date;

public class LuciferGUIController {

  private final MainView mainView;
  private final LoginView loginView;

  public LuciferGUIController(MainView mainView, LoginView loginView) {
    this.mainView = mainView;
    this.loginView = loginView;
  }

  public void showLogin(){
    mainView.setView(loginView);
  }

  public void setUpListener() {
    loginView.setLoginButtonListener(click -> {
      //TODO: complete
    });
  }
}
