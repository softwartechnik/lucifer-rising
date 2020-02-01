package de.softwartechnik.lucifer.tree;

import java.util.List;

public final class AnswerNode extends Node {
  private final List<DecisionNode> decisions;

  protected AnswerNode(
    String id,
    List<DecisionNode> decisions
  ) {
    super(id, decisions);
    this.decisions = decisions;
  }

  @Override
  public void accept(MessageContext messageContext) {
    var message = messageContext.message();
    var first = decisions.stream()
      .filter(decisionNode -> decisionNode.test(message))
      .findFirst();
    messageContext.follow(first.orElseThrow());
  }
}
