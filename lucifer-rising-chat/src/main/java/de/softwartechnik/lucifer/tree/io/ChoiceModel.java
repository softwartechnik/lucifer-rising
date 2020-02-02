package de.softwartechnik.lucifer.tree.io;

import java.util.Objects;

public final class ChoiceModel {
  private final String pattern;
  private final String nextNode;
  private int delay;

  public ChoiceModel(String matcher, String nextNode, int delay) {
    this.pattern = matcher;
    this.nextNode = nextNode;
    this.delay = delay;
  }

  public String pattern() {
    return pattern;
  }

  public String nextNode() {
    return nextNode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChoiceModel that = (ChoiceModel) o;
    return delay == that.delay &&
      Objects.equals(pattern, that.pattern) &&
      Objects.equals(nextNode, that.nextNode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pattern, nextNode, delay);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("ChoiceModel{");
    sb.append("pattern='").append(pattern).append('\'');
    sb.append(", nextNode='").append(nextNode).append('\'');
    sb.append(", delay=").append(delay);
    sb.append('}');
    return sb.toString();
  }
}