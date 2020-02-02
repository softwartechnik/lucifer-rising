package de.softwartechnik.lucifer.tree.node;

import de.softwartechnik.lucifer.tree.MessageContext;
import java.util.Objects;

public final class MessageNode implements Node {
  private final String message;
  private final Node nextNode;

  private MessageNode(String message, Node nextNode) {
    this.message = message;
    this.nextNode = nextNode;
  }

  public static MessageNode of(String message, Node nextNode) {
    Objects.requireNonNull(message);
    Objects.requireNonNull(nextNode);
    return new MessageNode(message, nextNode);
  }

  @Override
  public void accept(MessageContext messageContext) {
    messageContext.respond(message);
    messageContext.resume(nextNode);
  }
}
