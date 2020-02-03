package de.softwartechnik.lucifer.session.game;

import de.softwartechnik.lucifer.tree.ChatSession;
import de.softwartechnik.lucifer.tree.MessageContext;
import de.softwartechnik.lucifer.tree.node.Node;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;

public class Game implements ChatSession {
  private final String id;
  private final transient Queue chatMessages;
  private final transient JMSContext jmsContext;
  private Node currentNode;

  public Game(String id, Queue chatMessages, JMSContext jmsContext) {
    this.id = id;
    this.chatMessages = chatMessages;
    this.jmsContext = jmsContext;
  }

  @Override
  public void sendMessage(String message) {
    try {
      Message jmsMessage = jmsContext.createTextMessage(message);
      jmsMessage.setStringProperty("userId", "userId");
      jmsMessage.setStringProperty("sessionId", id);
      jmsMessage.setStringProperty("type", "bot");
      jmsContext.createProducer().send(chatMessages, message);
    } catch (JMSException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void setCurrentNode(Node node) {
    currentNode = node;
  }

  @Override
  public void end() {
    sendMessage("DU HAST GEWONNEN!");
  }

  @Override
  public void kill() {
    sendMessage("DU BIST TOT!");
  }

  public void begin(Node node, String message) {
    currentNode = node;
    onMessage(message);
  }

  public void onMessage(String message) {
    var messageContext = new MessageContext(this, message);
    currentNode.accept(messageContext);
  }

  @Override
  public String id() {
    return id;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Game{");
    sb.append("id='").append(id).append('\'');
    sb.append(", currentNode=").append(currentNode);
    sb.append('}');
    return sb.toString();
  }
}
