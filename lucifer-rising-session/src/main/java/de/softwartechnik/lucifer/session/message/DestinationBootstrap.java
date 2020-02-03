package de.softwartechnik.lucifer.session.message;

import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSDestinationDefinitions;
import javax.jms.Queue;

@JMSDestinationDefinitions(
  @JMSDestinationDefinition(
    name = "java:global/jms/ChatMessageQueue",
    interfaceName = "javax.jms.Queue",
    destinationName = "ChatMessageQueue"
  )
)
@Startup
@Singleton
public class DestinationBootstrap {
  @Resource(lookup = "java:global/jms/ChatMessageQueue")
  private Queue queue;
}
