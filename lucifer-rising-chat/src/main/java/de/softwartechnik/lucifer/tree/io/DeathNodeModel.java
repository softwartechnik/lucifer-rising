package de.softwartechnik.lucifer.tree.io;

final class DeathNodeModel implements NodeModel {
  public String id;
  public int delay;

  public DeathNodeModel(String id, int delay) {
    this.id = id;
    this.delay = delay;
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