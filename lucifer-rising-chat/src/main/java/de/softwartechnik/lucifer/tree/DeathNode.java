package de.softwartechnik.lucifer.tree;

import java.util.List;

public final class DeathNode extends Node {

  protected DeathNode(String id, List<Node> nextNodes) {
    super(id, nextNodes);
  }

  @Override
  public void accept(MessageContext messageContext) {
    messageContext.killSession();
  }
}
