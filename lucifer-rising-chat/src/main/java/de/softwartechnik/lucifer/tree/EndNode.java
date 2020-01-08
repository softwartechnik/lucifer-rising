package de.softwartechnik.lucifer.tree;

public final class EndNode implements Node {
  private EndNode() {
  }

  @Override
  public void accept(MessageContext messageContext) {
    messageContext.respond("Du hast gewonnen!");
    messageContext.winGame();
  }

  public static Node create() {
    return new EndNode();
  }
}
