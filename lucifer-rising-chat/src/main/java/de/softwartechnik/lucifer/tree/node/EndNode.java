package de.softwartechnik.lucifer.tree.node;

import de.softwartechnik.lucifer.tree.MessageContext;

public final class EndNode implements Node {
  private EndNode() {
  }

  public static Node create() {
    return new EndNode();
  }

  @Override
  public void accept(MessageContext messageContext) {
    messageContext.respond("Du hast gewonnen!");
    messageContext.winGame();
  }
}
