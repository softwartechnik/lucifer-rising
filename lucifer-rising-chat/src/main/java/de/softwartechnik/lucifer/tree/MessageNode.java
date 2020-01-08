package de.softwartechnik.lucifer.tree;

import java.util.Objects;

public final class MessageNode extends Node {
  private final String message;
  private final Node nextNode;

  private MessageNode(String message, Node nextNode) {
    this.message = message;
    this.nextNode = nextNode;
  }

  @Override
  public void accept(MessageContext messageContext) {
    messageContext.respond(message);
    messageContext.resume(nextNode);
  }

  public static MessageNode of(String message, Node nextNode) {
    Objects.requireNonNull(message);
    Objects.requireNonNull(nextNode);
    return new MessageNode(message, nextNode);
  }
}
