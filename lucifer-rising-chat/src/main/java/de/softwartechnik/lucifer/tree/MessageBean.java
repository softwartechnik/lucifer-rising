package de.softwartechnik.lucifer.tree;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@MessageDriven(activationConfig = {
  @ActivationConfigProperty(propertyName = "destination",
    propertyValue = "chatSession")
})
public class MessageBean implements MessageListener {

  //TODO: @Inject, MessageContext has to be a Bean
  private MessageContext messageContext;

  public MessageBean() {
  }

  @Override
  public void onMessage(Message message) {
    //TODO: receive, process, answer (sendMessage())
    sendMessage();
  }

  private void sendMessage() {
    try {
      var context = new InitialContext();
      var connectionFactory = (ConnectionFactory)
        context.lookup("/ConnectionFactory");
      var queue = (Queue) context.lookup("queue/chatSession");
      var connection = connectionFactory.createConnection();
      var session = connection.createSession();
      var messageProducer = session.createProducer(queue);
      connection.start();
      messageProducer.send(session.createTextMessage(messageContext.message()));
    } catch (NamingException | JMSException e) {
      e.printStackTrace();
    }
  }
}
