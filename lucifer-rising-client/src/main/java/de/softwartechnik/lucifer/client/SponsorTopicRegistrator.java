package de.softwartechnik.lucifer.client;

import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public final class SponsorTopicRegistrator implements MessageListener {

  private Context context;
  private JMSContext jmsContext;
  private Topic sponsorTopic;

  private SponsorTopicRegistrator() {
    try {
      context = new InitialContext();
    } catch (NamingException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void onMessage(Message message) {
    try {
      if (message.getJMSDestination().equals(sponsorTopic)) {
        var textMessage = (TextMessage) message;
        textMessage.getText();
        // TODO: Add message to client UI
      }
    } catch (JMSException e) {
      e.printStackTrace();
    }
  }

  private void initializeJmsConnections() {
    try {
      ConnectionFactory connectionFactory = (ConnectionFactory) context
        .lookup("java:comp/DefaultJMSConnectionFactory");
      jmsContext = connectionFactory.createContext();
      sponsorTopic = (Topic) context.lookup("java:global/jms/SponsorTopic");
      jmsContext.createConsumer(sponsorTopic).setMessageListener(this);
    } catch (NamingException e) {
      e.printStackTrace();
    }
  }

  public SponsorTopicRegistrator
  createSponsorTopicRegistratorWithJmsConnections() {
    var sponsorTopicRegistrator = new SponsorTopicRegistrator();
    sponsorTopicRegistrator.initializeJmsConnections();
    return sponsorTopicRegistrator;
  }
}
