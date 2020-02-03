package de.softwartechnik.lucifer.gui.swing.view;

import java.awt.event.ActionListener;
import javax.inject.Inject;
import javax.swing.JComponent;

public final class ScenarioView implements View {

  private final ScenarioPanel scenarioPanel;

  @Inject
  public ScenarioView(ScenarioPanel scenarioPanel) {
    this.scenarioPanel = scenarioPanel;
  }

  @Override
  public JComponent getComponent() {
    return scenarioPanel;
  }

  public void setActionListener(ActionListener actionListener) {
    scenarioPanel.getSend().addActionListener(actionListener);
    scenarioPanel.getExit().addActionListener(actionListener);
  }

  public void addTextToUserArea(String text) {
    scenarioPanel.getTextAreaUser().append(text + '\n');
  }

  public void addTextToLuciferArea(String text) {
    scenarioPanel.getTextAreaLucifer().append(text + '\n');
  }

  public void clearTextField() {
    scenarioPanel.getTextField().setText("");
  }
}
