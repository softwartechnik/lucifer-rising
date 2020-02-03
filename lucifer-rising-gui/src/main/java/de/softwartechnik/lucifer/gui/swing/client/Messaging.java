package de.softwartechnik.lucifer.gui.swing.client;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public final class Messaging implements MessageListener {
  private final MessageClient messageClient;

  public Messaging(MessageClient messageClient) {
    this.messageClient = messageClient;
  }

  // TODO: client needs to know his userId and sessionId
  @Override
  public void onMessage(Message message) {
    try {
      if (message.getJMSDestination().equals(messageClient.destination())) {
        var textMessage = (TextMessage) message;
        String userId = textMessage.getStringProperty("userId");
        String sessionId = textMessage.getStringProperty("sessionId");
        String type = textMessage.getStringProperty("type");
        if (userId.equals("") && sessionId.equals("")) {
          String messageText = textMessage.getText();
          // TODO: Add message to client UI
        }
      }
    } catch (JMSException e) {
      e.printStackTrace();
    }
  }

  public void sendMessage(String userId, String sessionId, String messageText) {
    try {
      Message message = messageClient.jmsContext().createTextMessage(messageText);
      message.setStringProperty("userId", userId);
      message.setStringProperty("sessionId", sessionId);
      message.setStringProperty("type", "user");
      messageClient.jmsContext().createProducer().send(messageClient.destination(), message);
    } catch (JMSException e) {
      e.printStackTrace();
    }
  }

  public static Messaging createMessagingWithJmsConnections() {
    return new Messaging(MessageClient.create());
  }
}
