package de.softwartechnik.lucifer.session.game;

import de.softwartechnik.lucifer.tree.ChatSession;
import de.softwartechnik.lucifer.tree.MessageContext;
import de.softwartechnik.lucifer.tree.node.Node;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Game implements ChatSession {
  private final String id;
  private final Queue<String> responseBuffer = new ArrayBlockingQueue<>(100);
  private Node currentNode;

  public Game(String id) {
    this.id = id;
  }

  @Override
  public void sendMessage(String message) {
    synchronized (responseBuffer) {
      responseBuffer.add(message);
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
  public List<String> responses() {
    List<String> responses = new ArrayList<>();
    synchronized (responseBuffer) {
      while (responseBuffer.peek() != null) {
        responses.add(responseBuffer.poll());
      }
    }
    return responses;
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
