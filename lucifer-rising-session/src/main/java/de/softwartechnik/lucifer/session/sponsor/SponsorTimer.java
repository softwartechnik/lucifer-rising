package de.softwartechnik.lucifer.session.sponsor;

import de.softwartechnik.lucifer.session.SessionRegistry;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;

@Singleton
public class SponsorTimer {
  private static final String SPONSOR = "Sponsor us on github: https://www.github.com/softwartechnik/lucifer-rising";
  @Inject
  private SessionRegistry sessionRegistry;

  @Schedule(second="*/10", minute="*",hour="*", persistent=false)
  public void displaySponsor() {
    sessionRegistry.findSessions().forEach(chatSession -> chatSession.sendMessage(SPONSOR));
  }
}
