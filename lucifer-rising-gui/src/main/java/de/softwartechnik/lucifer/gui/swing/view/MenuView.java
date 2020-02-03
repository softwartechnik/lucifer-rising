package de.softwartechnik.lucifer.gui.swing.view;

import java.awt.event.ActionListener;
import javax.inject.Inject;
import javax.swing.JComponent;

public final class MenuView implements View {

  private final MenuPanel menuPanel;

  @Inject
  public MenuView(MenuPanel menuPanel) {
    this.menuPanel = menuPanel;
  }

  @Override
  public JComponent getComponent() {
    return menuPanel;
  }

  public void setActionListener(ActionListener actionListener) {
    menuPanel.getZombieScenarioButton().addActionListener(actionListener);
    menuPanel.getApokalypseScenarioButton().addActionListener(actionListener);
    menuPanel.getLogoutButton().addActionListener(actionListener);
  }
}
