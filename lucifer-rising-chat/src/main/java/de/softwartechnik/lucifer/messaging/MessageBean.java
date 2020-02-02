package de.softwartechnik.lucifer.messaging;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.TextMessage;

@MessageDriven(mappedName = "java:global/jms/MessageQueue",
  activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType",
      propertyValue = "javax.jms.Queue")
  })
public class MessageBean implements MessageListener {

  @Inject
  private JMSContext jmsContext;

  @Resource(lookup = "java:global/jms/MessageQueue")
  private Queue messageQueue;

  public MessageBean() {
  }

  @Override
  public void onMessage(Message message) {
    try {
      var textMessage = (TextMessage) message;
      String userId = textMessage.getStringProperty("userId");
      String sessionId = textMessage.getStringProperty("sessionId");
      String messageText = textMessage.getText();
      //TODO: process received message to get answer
      String messageTextToSend = "TODO";
      sendMessage(userId, sessionId, messageTextToSend);
    } catch (JMSException e) {
      e.printStackTrace();
    }
  }

  private void sendMessage(String userId, String sessionId,
                           String messageText) {
    try {
      Message message = jmsContext.createTextMessage(messageText);
      message.setStringProperty("userId", userId);
      message.setStringProperty("sessionId", sessionId);
      jmsContext.createProducer().send(messageQueue, message);
    } catch (JMSException e) {
      e.printStackTrace();
    }
  }
}
