package de.softwartechnik.lucifer.statistics;

import de.softwartechnik.lucifer.user.User;
import de.softwartechnik.lucifer.user.UserService;

import javax.annotation.Resource;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;

@MessageDriven
public class GameStatisticsBean implements MessageListener {

  @Inject
  private UserService userService;

  @Inject
  private JMSContext jmsContext;

  @Resource(lookup = "java:global/jms/StaticticsQueue")
  private Queue statisticsQueue;

  public GameStatisticsBean() {
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
