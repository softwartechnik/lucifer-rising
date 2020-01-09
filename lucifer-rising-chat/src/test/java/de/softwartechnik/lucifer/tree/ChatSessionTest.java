package de.softwartechnik.lucifer.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import de.softwartechnik.lucifer.tree.ChatSession.Status;
import de.softwartechnik.lucifer.tree.QuestionNode.Choice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

final class ChatSessionTest {

  private ChatSession chatSession;

  @BeforeEach
  void setUp() {
    chatSession = new ChatSession();
  }

  @Test
  void testFlowSuccess() {
    var goodNode = MessageNode.of("Schön!", EndNode.create());
    var badNode = DeathNode.create();
    var startNode = QuestionNode.newBuilder()
      .withQuestion("Wie geht es dir?")
      .addChoice(Choice.of(answer -> answer.equals("gut"), goodNode))
      .addChoice(Choice.of(answer -> answer.equals("schlecht"), badNode))
      .create();

    chatSession.begin(startNode, "Hallo!");
    chatSession.onMessage("gut");

    var status = chatSession.status();
    assertEquals(Status.END, status);
  }

  @Test
  void testFlowDeath() {
    var goodNode = MessageNode.of("Schön!", EndNode.create());
    var badNode = DeathNode.create();
    var startNode = QuestionNode.newBuilder()
      .withQuestion("Wie geht es dir?")
      .addChoice(Choice.of(answer -> answer.equals("gut"), goodNode))
      .addChoice(Choice.of(answer -> answer.equals("schlecht"), badNode))
      .create();

    chatSession.begin(startNode, "Hallo!");
    chatSession.onMessage("schlecht");

    var status = chatSession.status();
    assertEquals(Status.KILLED, status);
  }

  @Test
  void testFlowInvalidAnswer() {
    var goodNode = MessageNode.of("Schön!", EndNode.create());
    var badNode = DeathNode.create();
    var startNode = QuestionNode.newBuilder()
      .withQuestion("Wie geht es dir?")
      .addChoice(Choice.of(answer -> answer.equals("gut"), goodNode))
      .addChoice(Choice.of(answer -> answer.equals("schlecht"), badNode))
      .create();

    chatSession.begin(startNode, "Hallo!");
    chatSession.onMessage("geht so");

    var status = chatSession.status();
    assertEquals(Status.RUNNING, status);
  }
}