package de.softwartechnik.lucifer.tree.io;

final class EndNodeModel implements NodeModel {
  public String id;
  public int delay;

  public EndNodeModel(String id, int delay) {
    this.id = id;
    this.delay = delay;
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