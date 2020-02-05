package de.softwartechnik.lucifer.gui.swing.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public final class MenuPanel extends BackgroundPanel {

  private JLabel userGamesPlayedValueLabel;
  private JLabel userGamesWonValueLabel;
  private JLabel gameGamesPlayedValueLabel;
  private JLabel gameGamesWonValueLabel;
  private JButton zombieScenarioButton;
  private JButton apokalypseScenarioButton;
  private JButton logoutButton;

  public MenuPanel() {
    super("/scull_background.jpg");
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
    add(buildStatisticsPanel(), constraints);

    logoutButton = new JButton("Logout");
    constraints.gridx = 0;
    constraints.gridy = 2;
    constraints.gridwidth = 1;
    add(logoutButton, constraints);
  }

  private JPanel buildScenarioPanel() {
    JPanel innerScenarioPanel = new JPanel(new BorderLayout());
    innerScenarioPanel.setOpaque(false);

    JPanel scenarioHeadPanel = new JPanel();
    scenarioHeadPanel.setBackground(new Color(255, 255, 255, 100));

    JLabel scenarioLabel = new JLabel("Szenarien");
    scenarioLabel.setFont(scenarioLabel.getFont().deriveFont(Font.BOLD, 22));
    scenarioHeadPanel.add(scenarioLabel);
    innerScenarioPanel.add(scenarioHeadPanel, BorderLayout.NORTH);

    JPanel bodyScenarioPanel = new JPanel(new GridLayout(1,2));
    bodyScenarioPanel.setOpaque(false);
    bodyScenarioPanel.add(buildZombieScenarioPanel());
    bodyScenarioPanel.add(buildApokalypseScenarioPanel());
    innerScenarioPanel.add(bodyScenarioPanel, BorderLayout.CENTER);

    return innerScenarioPanel;
  }

  private JPanel buildStatisticsPanel() {
    JPanel statisticsPanel = new JPanel(new BorderLayout());
    statisticsPanel.setOpaque(false);

    JPanel statisticsHeadPanel = new JPanel();
    statisticsHeadPanel.setBackground(new Color(255, 255, 255, 100));
    
    JLabel statisticsLabel = new JLabel("Statistiken");
    statisticsLabel.setFont(statisticsLabel.getFont().deriveFont(Font.BOLD, 22));
    statisticsHeadPanel.add(statisticsLabel);
    statisticsPanel.add(statisticsHeadPanel, BorderLayout.NORTH);

    JPanel bodyStatisticsPanel = new JPanel(new GridLayout(1,2));
    bodyStatisticsPanel.setOpaque(false);
    bodyStatisticsPanel.add(buildUserStatisticPanel());
    bodyStatisticsPanel.add(buildGameStatisticPanel());
    statisticsPanel.add(bodyStatisticsPanel, BorderLayout.CENTER);

    return statisticsPanel;
  }

  private JPanel buildZombieScenarioPanel() {
    JPanel zombieScenarioPanel = new BackgroundPanel("/zombie_hands.png");
    zombieScenarioPanel.setBackground(new Color(255, 255, 255, 100));

    JLabel zombieScenarioHeadLabel = new JLabel("Zombie Outbreak");
    JPanel zombieScenarioHeadPanel = new JPanel();
    zombieScenarioHeadLabel.setFont(zombieScenarioHeadLabel.getFont().deriveFont(Font.BOLD));
    zombieScenarioHeadLabel.setForeground(Color.WHITE);
    zombieScenarioHeadPanel.setBackground(new Color(0, 0, 0, 150));
    zombieScenarioHeadPanel.add(zombieScenarioHeadLabel);
    zombieScenarioPanel.add(zombieScenarioHeadPanel, BorderLayout.NORTH);
    JLabel zombieScenarioInfoPanel = new JLabel(
      "<html><p style=\"width=400px\">Ein gew\u00f6hnlicher Tag an der FH oder doch "
        + "ein ausgewachsenes Abenteuer mit heiklen Situationen, schwierigen"
        + " Entscheidungen und Nervenkitzel pur? Hier ist survival instinct gefragt.</p></html>"
    );
    zombieScenarioInfoPanel.setForeground(Color.WHITE);
    zombieScenarioPanel.add(zombieScenarioInfoPanel, BorderLayout.CENTER);
    zombieScenarioButton = new JButton("Zombie Outbreak spielen");
    JPanel zombieScenarioButtonPanel = new JPanel();
    zombieScenarioButtonPanel.setBackground(zombieScenarioHeadPanel.getBackground());
    zombieScenarioButtonPanel.add(zombieScenarioButton);
    zombieScenarioPanel.add(zombieScenarioButtonPanel, BorderLayout.SOUTH);
    return zombieScenarioPanel;
  }

  private JPanel buildApokalypseScenarioPanel() {
    JPanel apokalypseScenarioPanel = new BackgroundPanel("/meteor_rain.png");
    apokalypseScenarioPanel.setBackground(new Color(255, 255, 255, 100));

    JLabel apokalypseScenarioHeadLabel = new JLabel("Apokalypse");
    JPanel apokalypseScenarioHeadPanel = new JPanel();
    apokalypseScenarioHeadLabel.setFont(apokalypseScenarioHeadLabel.getFont().deriveFont(Font.BOLD));
    apokalypseScenarioHeadLabel.setForeground(Color.WHITE);
    apokalypseScenarioHeadPanel.setBackground(new Color(0, 0, 0, 150));
    apokalypseScenarioHeadPanel.add(apokalypseScenarioHeadLabel);
    apokalypseScenarioPanel.add(apokalypseScenarioHeadPanel, BorderLayout.NORTH);
    JLabel apokalypseScenarioInfoPanel = new JLabel(
      "<html><p style=\"width=400px\">Wem nach d\u00fcsterer (Spiel-)Stimmung ist, der"
        + " ist hier genau richtig. Der Mann auf dem wei\u00dfen Pferd l\u00e4utet die Apokalypse"
        + " ein! Wird die Welt in den Abgrund sinken?</p></html>"
    );
    apokalypseScenarioInfoPanel.setForeground(Color.WHITE);
    apokalypseScenarioPanel.add(apokalypseScenarioInfoPanel, BorderLayout.CENTER);
    apokalypseScenarioButton = new JButton("Apokalypse spielen");
    JPanel apokalypseScenarioButtonPanel = new JPanel();
    apokalypseScenarioButtonPanel.setBackground(apokalypseScenarioHeadPanel.getBackground());
    apokalypseScenarioButtonPanel.add(apokalypseScenarioButton);
    apokalypseScenarioPanel.add(apokalypseScenarioButtonPanel, BorderLayout.SOUTH);
    return apokalypseScenarioPanel;
  }

  private JPanel buildUserStatisticPanel() {
    JPanel innerUserStatisticPanel = new JPanel(new GridLayout(3, 2));
    innerUserStatisticPanel.setBackground(new Color(255, 255, 255, 100));

    JPanel userStatisticHeadPanel = new JPanel();
    JLabel userStatisticLabel = new JLabel("Benutzer-Statistiken");
    userStatisticLabel.setFont(userStatisticLabel.getFont().deriveFont(Font.BOLD));
    userStatisticLabel.setForeground(Color.WHITE);
    userStatisticHeadPanel.setBackground(new Color(0, 0, 0, 150));
    userStatisticHeadPanel.add(userStatisticLabel);
    innerUserStatisticPanel.add(userStatisticHeadPanel);

    JPanel userGamesPlayedPanel = new JPanel(new GridLayout(1, 2));
    JLabel userGamesPlayedLabel = new JLabel("Spiele gespielt: ");
    userGamesPlayedPanel.setOpaque(false);
    userGamesPlayedPanel.add(userGamesPlayedLabel);
    userGamesPlayedValueLabel = new JLabel();
    userGamesPlayedPanel.add(userGamesPlayedValueLabel);
    innerUserStatisticPanel.add(userGamesPlayedPanel);

    JPanel userGamesWonPanel = new JPanel(new GridLayout(1, 2));
    JLabel userGamesWonLabel = new JLabel("Spiele gewonnen: ");
    userGamesWonPanel.setOpaque(false);
    userGamesWonPanel.add(userGamesWonLabel);
    userGamesWonValueLabel = new JLabel();
    userGamesWonPanel.add(userGamesWonValueLabel);
    innerUserStatisticPanel.add(userGamesWonPanel);

    return innerUserStatisticPanel;
  }

  private JPanel buildGameStatisticPanel() {
    JPanel innerGameStatisticPanel = new JPanel(new GridLayout(3, 2));
    innerGameStatisticPanel.setBackground(new Color(255, 255, 255, 100));

    JPanel gameStatisticHeadPanel = new JPanel();
    JLabel gameStatisticLabel = new JLabel("Gesamt-Statistiken");
    gameStatisticLabel.setFont(gameStatisticLabel.getFont().deriveFont(Font.BOLD));
    gameStatisticLabel.setForeground(Color.WHITE);
    gameStatisticHeadPanel.setBackground(new Color(0, 0, 0, 150));
    gameStatisticHeadPanel.add(gameStatisticLabel);
    innerGameStatisticPanel.add(gameStatisticHeadPanel);

    JPanel gameGamesPlayedPanel = new JPanel(new GridLayout(1, 2));
    JLabel gameGamesPlayedLabel = new JLabel("Spiele gespielt: ");
    gameGamesPlayedPanel.setOpaque(false);
    gameGamesPlayedPanel.add(gameGamesPlayedLabel);
    gameGamesPlayedValueLabel = new JLabel();
    gameGamesPlayedPanel.add(userGamesPlayedValueLabel);
    innerGameStatisticPanel.add(gameGamesPlayedPanel);

    JPanel gameGamesWonPanel = new JPanel(new GridLayout(1, 2));
    JLabel gameGamesWonLabel = new JLabel("Spiele gewonnen: ");
    gameGamesWonPanel.setOpaque(false);
    gameGamesWonPanel.add(gameGamesWonLabel);
    gameGamesWonValueLabel = new JLabel();
    gameGamesWonPanel.add(userGamesWonValueLabel);
    innerGameStatisticPanel.add(gameGamesWonPanel);

    return innerGameStatisticPanel;
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
