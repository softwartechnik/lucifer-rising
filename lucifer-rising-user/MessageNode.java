package de.softwartechnik.lucifer;

import java.util.Collection;

public final class MessageNode extends Node {
  private final String response;

  private MessageNode(
    String id,
    String response,
    String description,
    Collection<Node> nextNodes
  ) {
    super(id, description, nextNodes);
    this.response = response;
  }

  @Override
  public void accept(MessageContext messageContext) {
    messageContext.sendMessage(response);
  }
}
