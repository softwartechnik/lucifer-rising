package de.softwartechnik.lucifer;

import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public final class AnswerNode extends Node implements Predicate<String> {
  private final Node node;
  private final Pattern pattern;

  protected AnswerNode(
    String id,
    String description,
    Node node,
    String answerPattern
  ) {
    super(id, description, List.of(node));
    this.node = node;
    pattern = Pattern.compile(answerPattern);
  }

  @Override
  public void accept(MessageContext messageContext) {
    messageContext.resume(node);
  }

  @Override
  public boolean test(String message) {
    var predicate = pattern.asMatchPredicate();
    return predicate.test(message);
  }
}
