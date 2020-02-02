package de.softwartechnik.lucifer.tree.io;

import java.util.Arrays;

public final class QuestionNodeModel implements NodeModel {
  private String id;
  private String question;
  private ChoiceModel[] choiceModels;
  private int delay;

  public QuestionNodeModel(String id, String question, ChoiceModel[] choiceModels, int delay) {
    this.id = id;
    this.question = question;
    this.choiceModels = choiceModels;
    this.delay = delay;
  }

  public String question() {
    return question;
  }

  public ChoiceModel[] choices() {
    return choiceModels;
  }

  @Override
  public String id() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof QuestionNodeModel)) {
      return false;
    }
    QuestionNodeModel q = (QuestionNodeModel) o;
    return q.id.equals(id) && q.question.equals(question) && Arrays.equals(q.choiceModels,
      choiceModels);
  }
}
