package de.softwartechnik.lucifer.tree;

import java.util.Collection;
import java.util.List;

public final class MessageNode extends Node {
  private final String message;
  private final Node nextNode;

  public MessageNode(
    String id,
    String message,
    Node nextNode
  ) {
    super(id, List.of(nextNode));
    this.message = message;
    this.nextNode = nextNode;
  }

  @Override
  public void accept(MessageContext messageContext) {
    messageContext.respond(message);
    messageContext.follow(nextNode);
  }
}
