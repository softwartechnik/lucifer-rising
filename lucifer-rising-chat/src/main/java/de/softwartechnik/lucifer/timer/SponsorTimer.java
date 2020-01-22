package de.softwartechnik.lucifer.timer;

import javax.annotation.Resource;
import javax.ejb.Timeout;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;

public class SponsorTimer {
  private static final int INITIAL_DURATION_MILLISECONDS = 30 * 1000;
  public static final int INTERVAL_DURATION_MILLISECONDS = 30 * 1000;

  @Resource
  private TimerService timerService;

  public void startTimer() {
    TimerConfig timerConfig = new TimerConfig("SponsorTimer", true);
    timerService.createIntervalTimer(INITIAL_DURATION_MILLISECONDS,
      INTERVAL_DURATION_MILLISECONDS, timerConfig);
  }

  @Timeout
  public void sendSponsorMessage() {
  }
}
