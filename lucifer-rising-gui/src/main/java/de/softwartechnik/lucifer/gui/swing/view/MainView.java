package de.softwartechnik.lucifer.gui.swing.view;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Logger;

public class MainView extends JFrame {
  private static final String TITLE = "Lucifer Rising";
  private final JPanel contentPane;
  private Logger logger = Logger.getLogger(MainView.TITLE);

  public MainView() {
    setTitle(TITLE);
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    setResizable(true);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    contentPane = new LuciferGUIViewPanel();
    setContentPane(contentPane);

    setVisible(true);
    repaint();
  }

  public void setView(LuciferGUIView view) {
    setContentView(view.getComponent());
  }

  private void setContentView(JComponent contentView) {
    contentPane.removeAll();
    contentPane.add(contentView);
    setVisible(true);
    repaint();
  }
}
