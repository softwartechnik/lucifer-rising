package de.softwartechnik.lucifer.tree.node;

import de.softwartechnik.lucifer.tree.MessageContext;

public final class DeathNode implements Node {
  private DeathNode() {
  }

  public static DeathNode create() {
    return new DeathNode();
  }

  @Override
  public void accept(MessageContext messageContext) {
    messageContext.killSession();
  }
}
