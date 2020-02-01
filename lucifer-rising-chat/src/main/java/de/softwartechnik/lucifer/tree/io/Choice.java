package de.softwartechnik.lucifer.tree.io;

final class Choice {
  public final String pattern;
  public final String nextNode;
  public int delay;

  public Choice(String matcher, String nextNode) {
    this.pattern = matcher;
    this.nextNode = nextNode;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Choice)) {
      return false;
    }
    Choice c = (Choice) o;
    return c.pattern.equals(pattern) && c.nextNode.equals(nextNode);
  }
}