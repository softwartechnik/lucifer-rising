package de.softwartechnik.lucifer.gui.swing.client;

import java.security.Security;
import java.util.Properties;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public final class MessageClient {
  private static final String DEFAULT_CONNECTION_FACTORY = "jms/RemoteConnectionFactory";
  private static final String DEFAULT_DESTINATION = "java:global/jms/ChatMessageQueue";
  private static final String INITIAL_CONTEXT_FACTORY = "org.wildfly.naming.client.WildFlyInitialContextFactory";
  private static final String PROVIDER_URL = "http-remoting://127.0.0.1:8070";

  private final Context context;
  private final Destination destination;
  private JMSContext jmsContext;

  private MessageClient() throws NamingException {
    final Properties env = new Properties();
    env.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
    env.put(Context.PROVIDER_URL, System.getProperty(Context.PROVIDER_URL, PROVIDER_URL));
    env.put(Context.SECURITY_PRINCIPAL, "test");
    env.put(Context.SECURITY_CREDENTIALS, "4Sr3sU*^");
    context = new InitialContext(env);

    String connectionFactoryString = System.getProperty("connection.factory", DEFAULT_CONNECTION_FACTORY);
    System.out.println(connectionFactoryString);
    ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup(connectionFactoryString);

    System.out.println("PRE LOOKUP!");

    String destinationString = System.getProperty("destination", DEFAULT_DESTINATION);

    System.out.println("LOOKING UP DEST: " + destinationString);

    destination = (Destination) context.lookup(destinationString);
    this.jmsContext = connectionFactory.createContext("test", "4Sr3sU*^");
  }

  public static MessageClient create() {
    try {
      return new MessageClient();
    } catch (NamingException e) {
      e.printStackTrace();
      return null;
    }
  }

  public JMSContext jmsContext() {
    return jmsContext;
  }

  public JMSProducer createProducer() {
    return jmsContext.createProducer();
  }

  public Destination destination() {
    return destination;
  }
}
