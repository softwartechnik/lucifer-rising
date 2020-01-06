package de.softwartechnik.lucifer.tree;

import java.util.List;
import java.util.Optional;

public final class QuestionNode extends Node {
  private final String message;
  private final AnswerNode answerNode;

  public QuestionNode(
    String id,
    String message, AnswerNode answerNode
  ) {
    super(id, List.of(answerNode));
    this.message = message;
    this.answerNode = answerNode;
  }

  @Override
  public void accept(MessageContext messageContext) {
    messageContext.respond(message);
    messageContext.resume(answerNode);
  }
}
