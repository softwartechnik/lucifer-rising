package de.softwartechnik.lucifer.tree;

public final class DeathNode implements Node {
  private DeathNode() {
  }

  @Override
  public void accept(MessageContext messageContext) {
    messageContext.killSession();
  }

  public static DeathNode create() {
    return new DeathNode();
  }
}
