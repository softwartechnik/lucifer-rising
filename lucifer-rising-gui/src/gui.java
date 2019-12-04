import javafx.scene.input.KeyCode;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.awt.event.*;

public class gui {

  private JTextField textfield = new JTextField();
  private JButton send = new JButton("Senden");
  private JTextArea sendtextarea = new JTextArea();
  private JTextArea receivetextarea = new JTextArea();

  public void showgui(){

    //Build Frame
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500,500);

    JPanel panel = new JPanel();
    textfield.setColumns(15);
    panel.add(textfield);
    panel.add(send);

    frame.getContentPane().add(BorderLayout.SOUTH, panel);
    frame.getContentPane().add(BorderLayout.EAST, sendtextarea);
    frame.getContentPane().add(BorderLayout.WEST, receivetextarea);

    sendtextarea.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    receivetextarea.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

    sendtextarea.setLineWrap(true);
    receivetextarea.setLineWrap(true);
    sendtextarea.setEditable(false);
    receivetextarea.setEditable(false);

    //Event Handler
    textfield.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER)
        {
          sendText();
        }
      }
    });

    send.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        sendText();
      }
    });

    frame.setVisible(true);
  }

  private void sendText() {
    sendtextarea.append(textfield.getText() + "\n");
    receivetextarea.append("\n");
    textfield.setText("");
  }

  public void receiveText(String text) {
    receivetextarea.append(text + "\n");
    sendtextarea.append("\n");
  }
}
