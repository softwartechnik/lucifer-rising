package gson;

import java.util.Arrays;

public interface NodeModel {
}

final class MessageNodeModel implements NodeModel {
  public String id;
  public String message;
  public String nextNode;
  public int delay;

  public MessageNodeModel(String id, String message, String nextNode, int delay) {
    this.id = id;
    this.message = message;
    this.nextNode = nextNode;
    this.delay = delay;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof MessageNodeModel)) {
      return false;
    }
    MessageNodeModel m = (MessageNodeModel)o;
    return m.id.equals(id) && m.message.equals(message) && m.nextNode.equals(nextNode);
  }
}

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
