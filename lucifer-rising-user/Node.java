package de.softwartechnik.lucifer;

import java.util.Collection;
import java.util.Collections;
import java.util.function.Consumer;

public abstract class Node implements Consumer<MessageContext> {
  private final String id;
  private final String description;
  private final Collection<Node> nextNodes;

  protected Node(
    String id,
    String description,
    Collection<Node> nextNodes
  ) {
    this.id = id;
    this.description = description;
    this.nextNodes = nextNodes;
  }

  protected Collection<Node> nextNodes() {
    return Collections.unmodifiableCollection(nextNodes);
  }
}
