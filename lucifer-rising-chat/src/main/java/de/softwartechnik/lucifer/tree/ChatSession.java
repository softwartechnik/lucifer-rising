package de.softwartechnik.lucifer.tree;

import java.util.concurrent.atomic.AtomicReference;

public final class ChatSession {
  private Node currentNode;
  private final AtomicReference<Status> status = new AtomicReference<>(
    Status.LATENT
  );

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

  public enum  Status {
    LATENT,
    RUNNING,
    KILLED,
    END
  }
}
