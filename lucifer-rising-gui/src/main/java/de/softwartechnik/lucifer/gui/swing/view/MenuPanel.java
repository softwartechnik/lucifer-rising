package de.softwartechnik.lucifer.gui.swing.view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.inject.Inject;
import javax.swing.*;

public final class MenuPanel extends JPanel {

  private JLabel userGamesPlayedValueLabel;
  private JLabel userGamesWonValueLabel;
  private JLabel gameGamesPlayedValueLabel;
  private JLabel gameGamesWonValueLabel;
  private JButton zombieScenarioButton;
  private JButton apokalypseScenarioButton;
  private JButton logoutButton;

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

    logoutButton = new JButton("Logout");
    constraints.gridx = 0;
    constraints.gridy = 3;
    constraints.gridwidth = 2;
    add(logoutButton, constraints);
  }

  private JPanel buildScenarioPanel() {
    JPanel innerScenarioPanel = new JPanel(new BorderLayout());

    JPanel scenarioHeadPanel = new JPanel();
    JLabel scenarioLabel = new JLabel("Szenarien");
    scenarioHeadPanel.add(scenarioLabel);
    innerScenarioPanel.add(scenarioHeadPanel, BorderLayout.NORTH);

    JPanel bodyScenarioPanel = new JPanel(new GridLayout(1,2));
    bodyScenarioPanel.add(buildZombieScenarioPanel());
    bodyScenarioPanel.add(buildApokalypseScenarioPanel());
    innerScenarioPanel.add(bodyScenarioPanel, BorderLayout.CENTER);

    return innerScenarioPanel;
  }

  private JPanel buildZombieScenarioPanel() {
    JPanel zombieScenarioPanel = new JPanel(new BorderLayout());
    JLabel zombieScenarioHeadLabel = new JLabel("Zombie Outbreak");
    JPanel zombieScenarioHeadPanel = new JPanel();
    zombieScenarioHeadPanel.add(zombieScenarioHeadLabel);
    zombieScenarioPanel.add(zombieScenarioHeadPanel, BorderLayout.NORTH);
    JLabel zombieScenarioInfoPanel = new JLabel(
      "<html><p style=\"width=400px\">Ein gew\u00f6hnlicher Tag an der FH oder doch "
        + "ein ausgewachsenes Abenteuer mit heiklen Situationen, schwierigen"
        + " Entscheidungen und Nervenkitzel pur? Hier ist survival instinct gefragt.</p></html>"
    );
    zombieScenarioPanel.add(zombieScenarioInfoPanel, BorderLayout.CENTER);
    zombieScenarioButton = new JButton("Zombie Outbreak spielen");
    JPanel zombieScenarioButtonPanel = new JPanel();
    zombieScenarioButtonPanel.add(zombieScenarioButton);
    zombieScenarioPanel.add(zombieScenarioButtonPanel, BorderLayout.SOUTH);
    return zombieScenarioPanel;
  }

  private JPanel buildApokalypseScenarioPanel() {
    JPanel apokalypseScenarioPanel = new JPanel(new BorderLayout());
    JLabel apokalypseScenarioHeadLabel = new JLabel("Apokalypse");
    JPanel apokalypseScenarioHeadPanel = new JPanel();
    apokalypseScenarioHeadPanel.add(apokalypseScenarioHeadLabel);
    apokalypseScenarioPanel.add(apokalypseScenarioHeadPanel, BorderLayout.NORTH);
    JLabel apokalypseScenarioInfoPanel = new JLabel(
      "<html><p style=\"width=400px\">Wem nach d\u00fcsterer (Spiel-)Stimmung ist, der"
        + " ist hier genau richtig. Der Mann auf dem wei\u00dfen Pferd l\u00e4utet die Apokalypse"
        + " ein! Wird die Welt in den Abgrund sinken?</p></html>"
    );
    apokalypseScenarioPanel.add(apokalypseScenarioInfoPanel, BorderLayout.CENTER);
    apokalypseScenarioButton = new JButton("Apokalypse spielen");
    JPanel apokalypseScenarioButtonPanel = new JPanel();
    apokalypseScenarioButtonPanel.add(apokalypseScenarioButton);
    apokalypseScenarioPanel.add(apokalypseScenarioButtonPanel, BorderLayout.SOUTH);
    return apokalypseScenarioPanel;
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

  public JButton getZombieScenarioButton() {
    return zombieScenarioButton;
  }

  public JButton getApokalypseScenarioButton() {
    return apokalypseScenarioButton;
  }

  public JButton getLogoutButton() {
    return logoutButton;
  }
}
