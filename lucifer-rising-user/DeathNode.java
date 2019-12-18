package de.softwartechnik.lucifer;

import java.util.Collection;
import java.util.Objects;

public final class DeathNode extends Node {
  private final String deathMessage;

  private DeathNode(
    String id,
    String deathMessage,
    String description,
    Collection<Node> nextNodes
  ) {
    super(id, description, nextNodes);
    this.deathMessage = deathMessage;
  }

  @Override
  public void accept(MessageContext messageContext) {
    messageContext.destroy();
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static final class Builder {
    private String id;
    private String deathMessage;
    private String description;
    private Collection<Node> nextNodes;

    public Builder withId(String id) {
      Objects.requireNonNull(id);
      this.id = id;
      return this;
    }

    public Builder withDeathMessage(String deathMessage) {
      Objects.requireNonNull(deathMessage);
      this.deathMessage = deathMessage;
      return this;
    }

    public Builder withDescription(String description) {
      Objects.requireNonNull(description);
      this.description = description;
      return this;
    }

    public Builder addNextNode(Node node) {
      Objects.requireNonNull(node);
      nextNodes.add(node);
      return this;
    }

    public Builder withNextNodes(Iterable<Node> nextNodes) {
      Objects.requireNonNull(nextNodes);
      nextNodes.forEach(this::addNextNode);
      return this;
    }

    public DeathNode create() {
      Objects.requireNonNull(id);
      Objects.requireNonNull(deathMessage);
      Objects.requireNonNull(description);
      Objects.requireNonNull(nextNodes);
      return new DeathNode(id, deathMessage, description, nextNodes);
    }
  }
}
