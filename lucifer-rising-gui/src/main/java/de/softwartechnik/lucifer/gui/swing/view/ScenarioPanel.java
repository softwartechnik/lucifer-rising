package de.softwartechnik.lucifer.gui.swing.view;

import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public final class ScenarioPanel extends BackgroundPanel {
  private JScrollPane scrollPane;
  private JPanel chatPanel;
  private JTextField textField;
  private JButton send;
  private JButton exit;

  public ScenarioPanel() {
    super("/scull_background.jpg");
    JPanel mainPanel = new JPanel(new GridBagLayout());
    add(mainPanel);

    GridBagConstraints cs = new GridBagConstraints();
    cs.fill = GridBagConstraints.HORIZONTAL;

    chatPanel = new JPanel();
    chatPanel.setOpaque(false);
    chatPanel.setLayout(new BoxLayout(chatPanel, BoxLayout.Y_AXIS));

    scrollPane = new JScrollPane();
    scrollPane.getViewport().add(chatPanel, BorderLayout.CENTER);
    scrollPane.getViewport().setBackground(new Color(255, 255, 255, 100));
    scrollPane.setPreferredSize(new Dimension(400, 500));
    scrollPane.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);

    cs.gridx = 0;
    cs.gridy = 0;
    cs.gridwidth = 2;
    mainPanel.add(scrollPane, cs);

    textField = new JTextField(20);
    cs.gridx = 0;
    cs.gridy = 1;
    cs.gridwidth = 1;
    mainPanel.add(textField, cs);

    send = new JButton("Senden");
    cs.gridx = 1;
    cs.gridy = 1;
    cs.gridwidth = 1;
    mainPanel.add(send, cs);

    exit = new JButton("Speichern und verlassen");
    exit.setForeground(Color.WHITE);
    exit.setContentAreaFilled(false);
    exit.setBorderPainted(false);
    cs.gridx = 0;
    cs.gridy = 2;
    cs.gridwidth = 2;
    mainPanel.add(exit, cs);
  }

  public void clearChat() {
    chatPanel.removeAll();
  }

  public void addBotMessage(String message) {
    JPanel textPanel = createBotTextPanel(message);
    textPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
    chatPanel.add(textPanel);
    scrollDown(scrollPane);
  }

  public void addPlayerMessage(String message) {
    JPanel textPanel = createPlayerTextPanel(message);
    textPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
    chatPanel.add(textPanel);
    scrollDown(scrollPane);
  }

  public JTextField getTextField() {
    return textField;
  }

  public JButton getSend() {
    return send;
  }

  public JButton getExit() {
    return exit;
  }

  private JPanel createBotTextPanel(String text) {
    JPanel outerPanel = new JPanel(new BorderLayout());
    JLabel botTextLabel = new JLabel("<html><body style='width:128px'>" + text + "</body></html>");
    JPanel botTextPanel = new JPanel();
    botTextPanel.setBackground(new Color(123, 255, 123, 100));
    botTextPanel.add(botTextLabel);
    outerPanel.setBorder(new EmptyBorder(10, 0, 10, 0));
    outerPanel.setOpaque(false);
    outerPanel.add(botTextPanel);
    return outerPanel;
  }

  private JPanel createPlayerTextPanel(String text) {
    JPanel outerPanel = new JPanel(new BorderLayout());
    JLabel playerTextLabel = new JLabel("<html><body style='width:128px'>" + text + "</body></html>");
    JPanel playerTextPanel = new JPanel();
    playerTextPanel.add(playerTextLabel);
    playerTextPanel.setBackground(new Color(123, 123, 255, 100));
    outerPanel.setBorder(new EmptyBorder(10, 0, 10, 0));
    outerPanel.setOpaque(false);
    outerPanel.add(playerTextPanel);
    return outerPanel;
  }

  public static void scrollDown(JScrollPane scrollPane) {
    JScrollBar bar = scrollPane.getVerticalScrollBar();

    AdjustmentListener listener = new AdjustmentListener() {
        @Override
        public void adjustmentValueChanged(AdjustmentEvent e) {
            bar.setValue(bar.getMaximum());
            bar.removeAdjustmentListener(this);
        }
    };

    bar.addAdjustmentListener(listener);
  }
}
