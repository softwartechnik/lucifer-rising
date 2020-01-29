import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public final class Messaging implements MessageListener {

  private Context context;
  private JMSContext jmsContext;
  private Queue messageQueue;

  private Messaging() {
    try {
      context = new InitialContext();
    } catch (NamingException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void onMessage(Message message) {
    try {
      if(message.getJMSDestination().equals(messageQueue)) {
        var textMessage = (TextMessage) message;
        String userId = textMessage.getStringProperty("userId");
        String sessionId = textMessage.getStringProperty("sessionId");
        // TODO: client needs to know his userId and sessionId
        if (userId.equals("") && sessionId.equals("")) {
          String messageText = textMessage.getStringProperty("messageText");
          // TODO: Add message to client UI
        }
      }
    } catch (JMSException e) {
      e.printStackTrace();
    }
  }

  public void sendMessage(String userId, String sessionId, String messageText) {
    try {
      Message message = jmsContext.createTextMessage(messageText);
      message.setStringProperty("userId", userId);
      message.setStringProperty("sessionId", sessionId);
      message.setStringProperty("messageText", messageText);
      jmsContext.createProducer().send(messageQueue, message);
    } catch (JMSException e) {
      e.printStackTrace();
    }
  }

  private void initializeJmsConnections() {
    try {
      ConnectionFactory connectionFactory = (ConnectionFactory) context
        .lookup("java:comp/DefaultJMSConnectionFactory");
      jmsContext = connectionFactory.createContext();
      messageQueue = (Queue) context.lookup("java:global/jms/MessageQueue");
      jmsContext.createConsumer(messageQueue).setMessageListener(this);
    } catch (NamingException e) {
      e.printStackTrace();
    }
  }

  public Messaging createMessagingWithJmsConnections() {
    var messaging = new Messaging();
    messaging.initializeJmsConnections();
    return messaging;
  }
}
