package de.softwartechnik.lucifer.gui.swing.view;

import javax.inject.Inject;
import javax.swing.*;
import java.awt.*;

import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;

public final class ScenarioPanel extends JPanel {
  private JScrollPane scrollPane;
  private JTextArea textAreaLucifer;
  private JTextArea textAreaUser;
  private JTextField textField;
  private JButton send;
  private JButton exit;

  @Inject
  public ScenarioPanel() {
    setLayout(new GridBagLayout());
    GridBagConstraints cs = new GridBagConstraints();

    cs.fill = GridBagConstraints.HORIZONTAL;

    scrollPane = new JScrollPane();
    cs.gridx = 0;
    cs.gridy = 0;
    cs.gridwidth = 2;
    JPanel areaPanel = new JPanel(new GridBagLayout());
    GridBagConstraints paneCs = new GridBagConstraints();

    textAreaLucifer = new JTextArea(20, 12);
    textAreaLucifer.setEditable(false);
    paneCs.gridx = 0;
    paneCs.gridy = 0;
    paneCs.gridwidth = 1;
    areaPanel.add(textAreaLucifer, paneCs);

    textAreaUser = new JTextArea(20, 12);
    textAreaUser.setEditable(false);
    paneCs.gridx = 1;
    paneCs.gridy = 0;
    paneCs.gridwidth = 1;
    areaPanel.add(textAreaUser, paneCs);

    scrollPane.getViewport().add(areaPanel);
    scrollPane.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
    add(scrollPane, cs);

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

  public JTextArea getTextAreaLucifer() {
    return textAreaLucifer;
  }

  public JTextArea getTextAreaUser() {
    return textAreaUser;
  }

  public JTextField getTextField() { return textField; }

  public JButton getSend() { return send; }

  public JButton getExit() { return exit;}
}
