package de.softwartechnik.lucifer.tree.io;

public final class DeathNodeModel implements NodeModel {
  private String id;
  private int delay;

  public DeathNodeModel(String id, int delay) {
    this.id = id;
    this.delay = delay;
  }

  @Override
  public String id() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof DeathNodeModel)) {
      return false;
    }
    DeathNodeModel d = (DeathNodeModel) o;
    return d.id.equals(id);
  }
}