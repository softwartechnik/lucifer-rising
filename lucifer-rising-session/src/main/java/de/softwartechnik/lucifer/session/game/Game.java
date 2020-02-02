package de.softwartechnik.lucifer.session.game;

import de.softwartechnik.lucifer.session.message.ChatMessages;
import de.softwartechnik.lucifer.tree.ChatSession;
import de.softwartechnik.lucifer.tree.MessageContext;
import de.softwartechnik.lucifer.tree.node.Node;

public class Game implements ChatSession {
  private final String id;
  private final ChatMessages chatMessages;
  private Node currentNode;

  public Game(String id, ChatMessages chatMessages) {
    this.id = id;
    this.chatMessages = chatMessages;
  }

  @Override
  public void sendMessage(String message) {
    chatMessages.sendMessage("", id, message);
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
}
