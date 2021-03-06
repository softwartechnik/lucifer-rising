package de.softwartechnik.lucifer.tree.io;

public final class EndNodeModel implements NodeModel {
  private String id;
  private int delay;

  public EndNodeModel(String id, int delay) {
    this.id = id;
    this.delay = delay;
  }

  @Override
  public String id() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof EndNodeModel)) {
      return false;
    }
    EndNodeModel e = (EndNodeModel) o;
    return e.id.equals(id);
  }
}