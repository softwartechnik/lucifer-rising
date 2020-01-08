package de.softwartechnik.lucifer.tree;

public final class EndNode extends Node {
  private EndNode() {
  }

  @Override
  public void accept(MessageContext messageContext) {
    messageContext.respond("Du hast gewonnen!");
  }

  public static Node create() {
    return new EndNode();
  }
}
