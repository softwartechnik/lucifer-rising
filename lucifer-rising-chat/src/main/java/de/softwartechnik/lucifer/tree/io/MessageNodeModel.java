package de.softwartechnik.lucifer.tree.io;

public final class MessageNodeModel implements NodeModel {
  private String id;
  private String message;
  private String nextNode;
  private int delay;

  public MessageNodeModel(String id, String message, String nextNode, int delay) {
    this.id = id;
    this.message = message;
    this.nextNode = nextNode;
    this.delay = delay;
  }

  public String message() {
    return message;
  }

  public String nextNode() {
    return nextNode;
  }

  @Override
  public String id() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof MessageNodeModel)) {
      return false;
    }
    MessageNodeModel m = (MessageNodeModel) o;
    return m.id.equals(id) && m.message.equals(message) && m.nextNode.equals(nextNode);
  }
}