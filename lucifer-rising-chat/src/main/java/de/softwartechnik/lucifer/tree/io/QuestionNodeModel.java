package de.softwartechnik.lucifer.tree.io;

import java.util.Arrays;

final class QuestionNodeModel implements NodeModel {
  public String id;
  public String question;
  public Choice[] choices;
  public int delay;

  public QuestionNodeModel(String id, String question, Choice[] choices, int delay) {
    this.id = id;
    this.question = question;
    this.choices = choices;
    this.delay = delay;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof QuestionNodeModel)) {
      return false;
    }
    QuestionNodeModel q = (QuestionNodeModel) o;
    return q.id.equals(id) && q.question.equals(question) && Arrays.equals(q.choices, choices);
  }
}
