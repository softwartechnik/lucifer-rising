package de.softwartechnik.lucifer.timer;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(activationConfig = {
  @ActivationConfigProperty(propertyName = "destination",
    propertyValue = "sponsorTopic"),
  @ActivationConfigProperty(propertyName = "destinationType",
    propertyValue = "javax.jms.Topic")
})
public class SponsorTopicRegistrator implements MessageListener {

  public SponsorTopicRegistrator() {
  }

  @Override
  public void onMessage(Message message) {
    //TODO: add or remove from sponsor topic, start sponsor timer
  }
}
