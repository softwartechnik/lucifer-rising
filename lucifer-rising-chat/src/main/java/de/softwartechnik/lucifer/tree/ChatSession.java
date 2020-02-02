package de.softwartechnik.lucifer.tree;

import de.softwartechnik.lucifer.tree.node.Node;
import de.softwartechnik.lucifer.tree.node.Tree;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

public final class ChatSession {
  private final String id;
  private final AtomicReference<Status> status = new AtomicReference<>(Status.LATENT);
  private Node currentNode;

  public ChatSession(String id) {
    this.id = id;
  }

  public void begin(Node node, String message) {
    currentNode = node;
    status.compareAndSet(Status.LATENT, Status.RUNNING);
    onMessage(message);
  }

  public void onMessage(String message) {
    var messageContext = new MessageContext(this, message);
    currentNode.accept(messageContext);
  }

  public void setCurrentNode(Node currentNode) {
    this.currentNode = currentNode;
  }

  public Status status() {
    return status.get();
  }

  void updateStatus(Status status) {
    this.status.set(status);
  }

  public void sendMessage(String message) {
  }

  public String id() {
    return id;
  }

  public enum Status {
    LATENT,
    RUNNING,
    KILLED,
    END
  }

  public static ChatSession of(Tree tree) {
    Objects.requireNonNull(tree);
    return new ChatSession(UUID.randomUUID().toString());
  }
}
