package de.softwartechnik.lucifer.gui.swing.view;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Scenarioselection {
  private JLabel headerlabel;
  private JButton zombieOutbreakButton;
  private JButton apokalypseButton;
  private JTextArea infotextArea;
  private JPanel scenarioselectionpanel;
  private JFrame frame = new JFrame();

  void guiScenarioselection() {
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(700, 500);

    frame.setContentPane(scenarioselectionpanel);

    zombieOutbreakButton.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseEntered(MouseEvent e) {
        zombieOutbreakButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        infotextArea.setText("Wem nach Nervenkizel und schwierigen Entscheidungen ist, \n"
          + "der ist hier genau richtig. \n"
          + "Nach einem Zombie Outbreak in der FH, schreibt dich eine Nummer an. \n"
          + "Schaffst du die richtigen Entscheidungen zu treffen, so das ihr beide überlebt?");
      }
    });

    zombieOutbreakButton.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseExited(MouseEvent e) {
        infotextArea.setText("");
      }
    });

    apokalypseButton.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseEntered(MouseEvent e) {
        apokalypseButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        infotextArea
          .setText("Wem nach düsterer (Spiel-)Stimmung ist, der ist hier genau richtig. \n"
            + "Der Mann auf dem weißen Pferd läutet hier nämlich nicht etwa eine rührende \n"
            + "Liebesgeschichte ein, sondern die Apokalypse. \n"
            + "Wird die Welt in den Abgrund sinken? \n");
      }
    });

    apokalypseButton.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseExited(MouseEvent e) {
        infotextArea.setText("");
      }
    });

    zombieOutbreakButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        Scenario s = new Scenario();
        s.guiscenario(1);
        frame.setVisible(false);
      }
    });

    apokalypseButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        Scenario s = new Scenario();
        s.guiscenario(2);
        frame.setVisible(false);
      }
    });

    frame.setVisible(true);
  }

}
