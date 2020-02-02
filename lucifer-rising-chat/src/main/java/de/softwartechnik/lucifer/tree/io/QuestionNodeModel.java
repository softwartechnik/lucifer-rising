package de.softwartechnik.lucifer.tree.io;

import java.util.Arrays;
import java.util.Objects;

public final class QuestionNodeModel implements NodeModel {
  private String id;
  private String question;
  private ChoiceModel[] choices;
  private int delay;

  public QuestionNodeModel(String id, String question, ChoiceModel[] choices, int delay) {
    this.id = id;
    this.question = question;
    this.choices = choices;
    this.delay = delay;
  }

  public String question() {
    return question;
  }

  public ChoiceModel[] choices() {
    return choices;
  }

  @Override
  public String id() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QuestionNodeModel that = (QuestionNodeModel) o;
    return delay == that.delay &&
      Objects.equals(id, that.id) &&
      Objects.equals(question, that.question) &&
      Arrays.equals(choices, that.choices);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(id, question, delay);
    result = 31 * result + Arrays.hashCode(choices);
    return result;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("QuestionNodeModel{");
    sb.append("id='").append(id).append('\'');
    sb.append(", question='").append(question).append('\'');
    sb.append(", choices=").append(Arrays.toString(choices));
    sb.append(", delay=").append(delay);
    sb.append('}');
    return sb.toString();
  }
}
