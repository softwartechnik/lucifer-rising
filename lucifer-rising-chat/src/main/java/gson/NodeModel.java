package gson;

import java.util.Set;
import java.util.function.Predicate;

public interface NodeModel {
}

final class MessageNodeModel implements NodeModel {
  String id;
  String nextNode;

  public MessageNodeModel(String id, String nextNode) {
    this.id = id;
    this.nextNode = nextNode;
  }
}
final class QuestionNodeModel implements NodeModel {
  String id;
  String question;
  Set<Choice> choices;

  public QuestionNodeModel(String id, String question, Set<Choice> choices) {
    this.id = id;
    this.question = question;
    this.choices = choices;
  }
}
final class DeathNodeModel implements NodeModel {
  String id;

  public DeathNodeModel(String id) {
    this.id = id;
  }
}
final class Choice {
  private final String matcher;
  private final String nextNode;

  public Choice(String matcher, String nextNode) {
    this.matcher = matcher;
    this.nextNode = nextNode;
  }
}
