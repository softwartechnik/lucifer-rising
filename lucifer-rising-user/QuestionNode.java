package de.softwartechnik.lucifer;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public final class QuestionNode extends Node {
  private final String question;

  private QuestionNode(
    String question,
    String id,
    String description,
    Collection<Node> nextNode
  ) {
    super(id, description, nextNode);
    this.question = question;
  }

  public String question() {
    return question;
  }

  @Override
  public String apply(MessageContext messageContext) {
    var decisionNode = matchDecision(messageContext);
    var decision = decisionNode.orElse(null);
    return messageContext.resume(decision);
  }

  private Optional<DecisionNode> matchDecision(MessageContext message) {
    return getOptions().stream()
      .filter(decisionNode -> decisionNode.test(message.getMessage()))
      .findFirst();
  }

  private List<DecisionNode> getOptions() {
    return nextNodes().stream()
      .filter(this::isDecision)
      .map(this::castDecisionNode)
      .collect(Collectors.toList());
  }

  private DecisionNode castDecisionNode(Node node) {
    return (DecisionNode) node;
  }

  private boolean isDecision(Node node) {
    return node instanceof DecisionNode;
  }

  private static final class DefaultDecision extends Node {
    private static final String MESSAGE = "You didn't answer the question";

    private DefaultDecision() {
      super(UUID.randomUUID().toString(), "description", List.of());
    }

    @Override
    public String apply(MessageContext messageContext) {
      return MESSAGE;
    }
  }
}
