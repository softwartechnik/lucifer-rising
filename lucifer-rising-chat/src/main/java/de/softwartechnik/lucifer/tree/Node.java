package de.softwartechnik.lucifer.tree;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

public abstract class Node implements Consumer<MessageContext> {
  private final String id;
  private final List<? extends Node> nextNodes;

  protected Node(
    String id,
    List<? extends Node> nextNodes
  ) {
    this.id = id;
    this.nextNodes = nextNodes;
  }

  public String id() {
    return id;
  }

  public List<? extends Node> nextNodes() {
    return nextNodes;
  }
}
