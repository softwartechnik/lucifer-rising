package de.softwartechnik.lucifer.gui.swing.view;

import javax.inject.Inject;
import javax.swing.*;
import java.awt.*;

public final class ScenarioPanel extends JPanel {
  private JTextArea textArea;
  private JTextField textField;
  private JButton send;
  private JButton exit;

  @Inject
  public ScenarioPanel() {
    setLayout(new GridBagLayout());
    GridBagConstraints cs = new GridBagConstraints();

    cs.fill = GridBagConstraints.HORIZONTAL;

    textArea = new JTextArea(20, 24);
    textArea.setEditable(false);
    cs.gridx = 0;
    cs.gridy = 0;
    cs.gridwidth = 2;
    add(textArea, cs);

    textField = new JTextField(15);
    textField.setBorder(BorderFactory.createEmptyBorder());
    cs.gridx = 0;
    cs.gridy = 1;
    cs.gridwidth = 3;
    add(textField, cs);

    send = new JButton("Senden");
    cs.gridx = 3;
    cs.gridy = 1;
    cs.gridwidth = 2;
    add(send, cs);

    exit = new JButton("Speichern und verlassen");
    exit.setContentAreaFilled(false);
    exit.setBorderPainted(false);
    cs.gridx = 0;
    cs.gridy = 3;
    add(exit, cs);
  }

  public JTextArea getTextArea() { return textArea; }

  public JTextField getTextField() { return textField; }

  public JButton getSend() { return send; }

  public JButton getExit() { return exit;}
}
