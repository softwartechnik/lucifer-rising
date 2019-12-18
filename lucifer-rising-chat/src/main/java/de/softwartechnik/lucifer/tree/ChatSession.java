package de.softwartechnik.lucifer.tree;

import java.util.List;
import java.util.regex.Pattern;

public class ChatSession {

  private Node currentNode;

  public static void main(String[] args) {
    new ChatSession().begin();
  }

  private void begin() {
    DeathNode deathNode = new DeathNode("death", List.of());
    DecisionNode decisionNode = new DecisionNode("decision", deathNode, Pattern.compile("(s|season)"));
    AnswerNode answerNode = new AnswerNode("answer", List.of(decisionNode));
    QuestionNode questionNode = new QuestionNode("question", "Bist du dumm?", answerNode);
    MessageNode rootNode = new MessageNode("rootNode", "Wie läufts?", questionNode);

    currentNode = rootNode;

    MessageContext messageContext = new MessageContext(this, "s");

    currentNode.accept(messageContext);

    MessageContext answer = new MessageContext(this, "s");

    currentNode.accept(answer);
  }

  public void setCurrentNode(Node currentNode) {
    this.currentNode = currentNode;
  }
}
