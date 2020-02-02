package de.softwartechnik.lucifer.session.game;

import de.softwartechnik.lucifer.user.User;
import de.softwartechnik.lucifer.user.UserService;
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

@JMSDestinationDefinition(
  name = "java:global/jms/StatisticsQueue",
  interfaceName = "javax.jms.Queue",
  destinationName = "StatisticsQueue"
)
@MessageDriven(
  activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup",
      propertyValue = "java:global/jms/StatisticsQueue")
  }
)
public class GameStatistics implements MessageListener {
  @Inject
  private UserService userService;
  @Inject
  private JMSContext jmsContext;
  @Resource(lookup = "java:global/jms/StatisticsQueue")
  private Queue statisticsQueue;

  public GameStatistics() {
  }

  @Override
  public void onMessage(Message message) {
    try {
      if (message.getJMSDestination().equals(statisticsQueue)) {
        sendMessage(buildMessage());
      }
    } catch (JMSException e) {
      e.printStackTrace();
    }
  }

  private Message buildMessage() throws JMSException {
    var message = jmsContext.createMapMessage();
    int sumGamesPlayed = 0;
    int sumGamesWon = 0;
    for (User user : userService.readAll()) {
      sumGamesPlayed += user.getGamesPlayed();
      sumGamesWon += user.getGamesWon();
    }
    message.setInt("gamesPlayed", sumGamesPlayed);
    message.setInt("gamesWon", sumGamesWon);
    return message;
  }

  private void sendMessage(Message message) {
    jmsContext.createProducer().send(statisticsQueue, message);
  }
}
