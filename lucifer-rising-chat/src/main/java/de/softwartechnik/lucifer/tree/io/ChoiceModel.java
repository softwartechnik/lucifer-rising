package de.softwartechnik.lucifer.tree.io;

public final class ChoiceModel {
  private final String pattern;
  private final String nextNode;
  private int delay;

  public ChoiceModel(String matcher, String nextNode) {
    this.pattern = matcher;
    this.nextNode = nextNode;
  }

  public String pattern() {
    return pattern;
  }

  public String nextNode() {
    return nextNode;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof ChoiceModel)) {
      return false;
    }
    ChoiceModel c = (ChoiceModel) o;
    return c.pattern.equals(pattern) && c.nextNode.equals(nextNode);
  }
}