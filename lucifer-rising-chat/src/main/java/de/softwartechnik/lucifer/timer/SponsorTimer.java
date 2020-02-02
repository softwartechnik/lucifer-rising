package de.softwartechnik.lucifer.timer;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Message;
import javax.jms.Topic;

@Singleton
@Startup
public final class SponsorTimer {
  private static final int INITIAL_DURATION_MILLISECONDS = 30 * 1000;
  private static final int INTERVAL_DURATION_MILLISECONDS = 30 * 1000;
  private static final String TIMER_INFO = "Sponsor us on GitHub!";

  @Inject
  private JMSContext jmsContext;

  @Resource(lookup = "java:global/jms/OberverTopic")
  private Topic sponsorTopic;

  @Resource
  private TimerService timerService;

  @PostConstruct
  private void startTimer() {
    TimerConfig timerConfig = new TimerConfig(TIMER_INFO, true);
    timerService.createIntervalTimer(INITIAL_DURATION_MILLISECONDS,
      INTERVAL_DURATION_MILLISECONDS, timerConfig);
  }

  @Timeout
  private void sendSponsorMessage() {
    Message message = jmsContext.createTextMessage(TIMER_INFO);
    jmsContext.createProducer().send(sponsorTopic, message);
  }
}
