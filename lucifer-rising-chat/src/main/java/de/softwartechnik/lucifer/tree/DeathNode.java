package de.softwartechnik.lucifer.tree;

import java.util.List;

public final class DeathNode extends Node {
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
