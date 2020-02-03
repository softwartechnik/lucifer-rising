package de.softwartechnik.lucifer.gui.swing.view;

import java.awt.*;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public final class MainFrame extends JFrame {
  private static final String TITLE = "Lucifer Rising";
  private final JPanel contentPane;
  private Logger logger = Logger.getLogger(MainFrame.TITLE);

  public MainFrame() {
    setTitle(TITLE);
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    setResizable(true);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    //contentPane = new LuciferGUIViewPanel();
    contentPane = new JPanel(new GridLayout(1, 1));
    setContentPane(contentPane);

    setVisible(true);
    repaint();
  }

  public void setView(View view) {
    setContentView(view.getComponent());
  }

  private void setContentView(JComponent contentView) {
    contentPane.removeAll();
    contentPane.add(contentView);
    setVisible(true);
    repaint();
  }

  // TODO: integrate background image
  public JPanel setBackgroundImage(String filename) {
    Image img = Toolkit.getDefaultToolkit().getImage(filename);
    return(new JPanel() {
      @Override
      public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, null);
      }
    });
  }
}
