package de.softwartechnik.lucifer;

import java.util.List;

public final class DecisionNode extends Node {
  private final Node nextNode;

  protected DecisionNode(
    String id,
    String description,
    Node nextNode
  ) {
    super(id, description, List.of(nextNode));
    this.nextNode = nextNode;
  }

  @Override
  public void accept(MessageContext message) {

  }
}
