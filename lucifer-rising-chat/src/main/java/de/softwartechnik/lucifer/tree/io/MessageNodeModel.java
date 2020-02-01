package de.softwartechnik.lucifer.tree.io;

final class MessageNodeModel implements NodeModel {
  public String id;
  public String message;
  public String nextNode;
  public int delay;

  public MessageNodeModel(String id, String message, String nextNode, int delay) {
    this.id = id;
    this.message = message;
    this.nextNode = nextNode;
    this.delay = delay;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof MessageNodeModel)) {
      return false;
    }
    MessageNodeModel m = (MessageNodeModel)o;
    return m.id.equals(id) && m.message.equals(message) && m.nextNode.equals(nextNode);
  }
}