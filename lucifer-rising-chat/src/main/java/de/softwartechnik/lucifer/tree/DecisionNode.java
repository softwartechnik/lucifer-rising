package de.softwartechnik.lucifer.tree;

import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class DecisionNode extends Node implements Predicate<String> {
  private final Node nextNode;
  private final Predicate<String> matcher;

  protected DecisionNode(
    String id,
    Node nextNode,
    Pattern pattern
  ) {
    super(id, List.of(nextNode));
    this.nextNode = nextNode;
    this.matcher = pattern.asMatchPredicate();
  }

  @Override
  public void accept(MessageContext messageContext) {
    messageContext.follow(nextNode);
  }

  @Override
  public boolean test(String message) {
    return matcher.test(message);
  }
}
