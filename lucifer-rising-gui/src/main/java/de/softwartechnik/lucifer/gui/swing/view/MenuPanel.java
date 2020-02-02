package de.softwartechnik.lucifer.gui.swing.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.inject.Inject;
import javax.swing.JLabel;
import javax.swing.JPanel;

public final class MenuPanel extends JPanel {

  private JLabel userGamesPlayedValueLabel;
  private JLabel userGamesWonValueLabel;
  private JLabel gameGamesPlayedValueLabel;
  private JLabel gameGamesWonValueLabel;

  @Inject
  public MenuPanel() {
    setLayout(new GridBagLayout());
    GridBagConstraints constraints = new GridBagConstraints();
    constraints.fill = GridBagConstraints.HORIZONTAL;

    buildScenarioPanel(constraints);

    buildUserStatisticPanel(constraints);

    buildGameStatisticPanel(constraints);
  }

  private void buildScenarioPanel(GridBagConstraints constraints) {
    JPanel scenarioPanel = new JPanel();// TODO layout

    JLabel scenarioLabel = new JLabel("Szenarien");
    scenarioPanel.add(scenarioLabel);
    // TODO add scenario-selector and button

    constraints.gridx = 0;
    constraints.gridy = 0;
    constraints.gridwidth = 1;
    add(scenarioPanel, constraints);
  }

  private void buildUserStatisticPanel(GridBagConstraints constraints) {
    JPanel userStatisticPanel = new JPanel(); // TODO layout

    JLabel userStatisticLabel = new JLabel("User-Statistiken");
    userStatisticPanel.add(userStatisticLabel);
    JLabel userGamesPlayedLabel = new JLabel("Spiele gespielt:");
    userStatisticPanel.add(userGamesPlayedLabel);
    userGamesPlayedValueLabel = new JLabel();
    userStatisticPanel.add(userGamesPlayedValueLabel);
    JLabel userGamesWonLabel = new JLabel("Spiele gewonnen:");
    userStatisticPanel.add(userGamesWonLabel);
    userGamesWonValueLabel = new JLabel();
    userStatisticPanel.add(userGamesWonValueLabel);

    constraints.gridx = 0;
    constraints.gridy = 1;
    constraints.gridwidth = 1;
    add(userStatisticPanel, constraints);
  }

  private void buildGameStatisticPanel(GridBagConstraints constraints) {
    JPanel gameStatisticPanel = new JPanel(); // TODO layout

    JLabel gameStatisticLabel = new JLabel("Gesamt-Statistiken");
    gameStatisticPanel.add(gameStatisticLabel);
    JLabel gameGamesPlayedLabel = new JLabel("Spiele gespielt:");
    gameStatisticPanel.add(gameGamesPlayedLabel);
    gameGamesPlayedValueLabel = new JLabel();
    gameStatisticPanel.add(gameGamesPlayedValueLabel);
    JLabel gameGamesWonLabel = new JLabel("Spiele gewonnen:");
    gameStatisticPanel.add(gameGamesWonLabel);
    gameGamesWonValueLabel = new JLabel();
    gameStatisticPanel.add(gameGamesWonValueLabel);

    constraints.gridx = 0;
    constraints.gridy = 2;
    constraints.gridwidth = 1;
    add(gameStatisticPanel, constraints);
  }

  public void setUserStatistics(int gamesPlayed, int gamesWon) {
    userGamesPlayedValueLabel.setText(Integer.toString(gamesPlayed));
    userGamesWonValueLabel.setText(Integer.toString(gamesWon));
  }

  public void setGameStatistics(int gamesPlayed, int gamesWon) {
    gameGamesPlayedValueLabel.setText(Integer.toString(gamesPlayed));
    gameGamesWonValueLabel.setText(Integer.toString(gamesWon));
  }
}
