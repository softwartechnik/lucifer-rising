package de.softwartechnik.lucifer.gui.swing.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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

    constraints.gridx = 0;
    constraints.gridy = 0;
    constraints.gridwidth = 1;
    add(buildScenarioPanel(), constraints);

    constraints.gridx = 0;
    constraints.gridy = 1;
    constraints.gridwidth = 1;
    add(buildUserStatisticPanel(), constraints);


    constraints.gridx = 0;
    constraints.gridy = 2;
    constraints.gridwidth = 1;
    add(buildGameStatisticPanel(), constraints);
  }

  private JPanel buildScenarioPanel() {
    JPanel scenarioPanel = new JPanel();// TODO layout

    JLabel scenarioLabel = new JLabel("Szenarien");
    scenarioPanel.add(scenarioLabel);
    // TODO add scenario-selector and button

    return scenarioPanel;
  }

  private JPanel buildUserStatisticPanel() {
    JPanel innerUserStatisticPanel = new JPanel(new GridLayout(3, 1)); // TODO layout

    JPanel userStatisticHeadPanel = new JPanel();
    JLabel userStatisticLabel = new JLabel("User-Statistiken");
    userStatisticHeadPanel.add(userStatisticLabel);
    innerUserStatisticPanel.add(userStatisticHeadPanel);
    JPanel userGamesPlayedPanel = new JPanel();
    JLabel userGamesPlayedLabel = new JLabel("Spiele gespielt:");
    userGamesPlayedPanel.add(userGamesPlayedLabel);
    userGamesPlayedValueLabel = new JLabel();
    userGamesPlayedPanel.add(userGamesPlayedValueLabel);
    innerUserStatisticPanel.add(userGamesPlayedPanel);
    JPanel userGamesWonPanel = new JPanel();
    JLabel userGamesWonLabel = new JLabel("Spiele gewonnen:");
    userGamesWonPanel.add(userGamesWonLabel);
    userGamesWonValueLabel = new JLabel();
    userGamesWonPanel.add(userGamesWonValueLabel);
    innerUserStatisticPanel.add(userGamesWonPanel);

    JPanel outerUserStatisticPanel = new JPanel();
    outerUserStatisticPanel.add(innerUserStatisticPanel);
    return outerUserStatisticPanel;
  }

  private JPanel buildGameStatisticPanel() {
    JPanel innerGameStatisticPanel = new JPanel(new GridLayout(3, 1)); // TODO layout

    JPanel gameStatisticHeadPanel = new JPanel();
    JLabel gameStatisticLabel = new JLabel("Gesamt-Statistiken");
    gameStatisticHeadPanel.add(gameStatisticLabel);
    innerGameStatisticPanel.add(gameStatisticHeadPanel);
    JPanel gameGamesPlayedPanel = new JPanel();
    JLabel gameGamesPlayedLabel = new JLabel("Spiele gespielt:");
    gameGamesPlayedPanel.add(gameGamesPlayedLabel);
    gameGamesPlayedValueLabel = new JLabel();
    gameGamesPlayedPanel.add(gameGamesPlayedValueLabel);
    innerGameStatisticPanel.add(gameGamesPlayedPanel);
    JPanel gameGamesWonPanel = new JPanel();
    JLabel gameGamesWonLabel = new JLabel("Spiele gewonnen:");
    gameGamesWonPanel.add(gameGamesWonLabel);
    gameGamesWonValueLabel = new JLabel();
    gameGamesWonPanel.add(gameGamesWonValueLabel);
    innerGameStatisticPanel.add(gameGamesWonPanel);

    JPanel outerGameStatisticPanel = new JPanel();
    outerGameStatisticPanel.add(innerGameStatisticPanel);
    return outerGameStatisticPanel;
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
