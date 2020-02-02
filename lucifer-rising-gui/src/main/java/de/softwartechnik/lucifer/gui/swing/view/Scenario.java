package de.softwartechnik.lucifer.gui.swing.view;

import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Scenario {
  JFrame frame = new JFrame();
  private JPanel scenariopanel;
  private JButton sendbutton;
  private JTextField textField;
  private JTextArea sendTextArea;
  private JTextArea receiveTextArea;
  private JPanel chatpanel;
  private JLabel scenarioname;

  void guiscenario(int scenarioseleted) {
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(700, 700);

    frame.setContentPane(scenariopanel);

    sendTextArea.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    receiveTextArea.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

    if (scenarioseleted == 1) {
      scenarioname.setText("Zombie Outbreak");
      scenarioname.setFont(new Font("OCR A Extended", Font.PLAIN, 24));
    } else if (scenarioseleted == 2) {
      scenarioname.setText("Apokalypse");
      scenarioname.setFont(new Font("Eras Light ITC", Font.PLAIN, 24));
    }

    textField.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
          textToServer();
        }
      }
    });

    sendbutton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        textToServer();
      }
    });

    frame.setVisible(true);
  }

  void textToServer() {
    sendTextArea.append(textField.getText() + "\n");
    receiveTextArea.append("\n");
    textField.setText("");
  }

  public void textToClient(String text) {
    receiveTextArea.append(text + "\n");
    sendTextArea.append("\n");

    //Bedingung beim Gewinnen
    if (true) {
      Object[] options = {"Scenario auswahl", "Schließen"};
      int selected = JOptionPane
        .showOptionDialog(frame, "Sie haben gewonnen Herzlichen Glückwunsche.", "Wählen Sie",
          JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[1]);
      if (selected == 0) {
        Scenarioselection s = new Scenarioselection();
        s.guiScenarioselection();
        frame.setVisible(false);
      } else if (selected == 1) {
        System.exit(0);
      }

    } else if (false) {
      Object[] options = {"Scenario auswahl", "Schließen"};
      int selected = JOptionPane
        .showOptionDialog(frame, "Sie haben Verloren", "Wählen Sie", JOptionPane.DEFAULT_OPTION,
          JOptionPane.INFORMATION_MESSAGE, null, options, options[1]);
      if (selected == 0) {
        Scenarioselection s = new Scenarioselection();
        s.guiScenarioselection();
        frame.setVisible(false);
      } else if (selected == 1) {
        System.exit(0);
      }
    }
  }
}
