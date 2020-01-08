package de.softwartechnik.lucifer.tree;

import de.softwartechnik.lucifer.tree.QuestionNode.Choice;

public final class ChatSession {
  private Node currentNode;

  public static void main(String[] args) {
    new ChatSession().begin();
  }

  private void begin() {
    var goodNode = MessageNode.of("Schön!", EndNode.create());
    var badNode = DeathNode.create();
    currentNode = QuestionNode.newBuilder()
      .withQuestion("Wie geht es dir?")
      .addChoice(Choice.of(answer -> answer.equals("gut"), goodNode))
      .addChoice(Choice.of(answer -> answer.equals("schlecht"), badNode))
      .create();

    var messageContext = new MessageContext(this, "Hey!");
    currentNode.accept(messageContext);

    System.out.println(currentNode);

    messageContext = new MessageContext(this, "schlecht");
    currentNode.accept(messageContext);

    System.out.println(currentNode);
  }

  public void setCurrentNode(Node currentNode) {
    this.currentNode = currentNode;
  }
}
