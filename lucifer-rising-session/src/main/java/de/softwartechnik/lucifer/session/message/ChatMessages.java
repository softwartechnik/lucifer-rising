package de.softwartechnik.lucifer.session.message;

import de.softwartechnik.lucifer.session.SessionRegistry;
import de.softwartechnik.lucifer.tree.ChatSession;
import java.util.Optional;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.TextMessage;

@MessageDriven(
  mappedName = "java:global/jms/ChatMessageQueue",
  activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup",
      propertyValue = "java:global/jms/ChatMessageQueue"),
    @ActivationConfigProperty(propertyName = "destinationType",
      propertyValue = "javax.jms.Queue")
  })
public class ChatMessages implements MessageListener {
  @Inject
  private JMSContext jmsContext;
  @Inject
  private SessionRegistry sessionRegistry;

  public ChatMessages() {
  }

  @Override
  public void onMessage(Message message) {
    try {
      var textMessage = (TextMessage) message;

      String messageType = textMessage.getStringProperty("type");
      if (messageType == null || messageType.equalsIgnoreCase("bot")) {
        return;
      }

      String userId = textMessage.getStringProperty("userId");
      String sessionId = textMessage.getStringProperty("sessionId");
      String messageText = textMessage.getText();
      processMessage(userId, sessionId, messageText);
    } catch (JMSException e) {
      e.printStackTrace();
    }
  }

  private void processMessage(
    String userId,
    String sessionId,
    String messageText
  ) {
    System.out.println("Processing message: " + sessionId + " with content: " + messageText);
    Optional<ChatSession> session = sessionRegistry.findSession(sessionId);
    ChatSession chatSession = session.orElseThrow();
    chatSession.onMessage(messageText);
  }
}
