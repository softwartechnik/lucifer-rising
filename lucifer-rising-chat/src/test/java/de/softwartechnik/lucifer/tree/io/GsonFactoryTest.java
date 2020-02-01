package de.softwartechnik.lucifer.tree.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.gson.JsonParseException;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class GsonFactoryTest {
  private final String filepathNodeDir = "/src/test/resources/nodefiles/";
  private GsonFactory gsonFactory;

  @BeforeEach
  void setUp() {
    gsonFactory = new GsonFactory();
  }

  @Test
  void testGetQuestionNodeFromFile() {
    String file = "test_question_node.json";
    QuestionNodeModel expectedNode = new QuestionNodeModel("2",
      "How much is the fish?",
      new Choice[]{new Choice("RegEx", "3"), new Choice("OtherRegEx", "4")}, 1000);
    List<NodeModel> result = gsonFactory.getNodesFromFile(filepathNodeDir + file);

    assertEquals(expectedNode, result.get(0));
  }

  @Test
  void testGetMessageNodeFromFile() {
    String file = "test_message_node.json";
    MessageNodeModel expectedNode = new MessageNodeModel("2", "This much is the fish", "3", 1000);
    List<NodeModel> result = gsonFactory.getNodesFromFile(filepathNodeDir + file);

    assertEquals(expectedNode, result.get(0));
  }

  @Test
  void testGetDeathNodeFromFile() {
    String file = "test_death_node.json";
    DeathNodeModel expectedNode = new DeathNodeModel("2", 1000);
    List<NodeModel> result = gsonFactory.getNodesFromFile(filepathNodeDir + file);

    assertEquals(expectedNode, result.get(0));
  }

  @Test
  void testGetEndNodeFromFile() {
    String file = "test_end_node.json";
    EndNodeModel expectedNode = new EndNodeModel("2", 1000);
    List<NodeModel> result = gsonFactory.getNodesFromFile(filepathNodeDir + file);

    assertEquals(expectedNode, result.get(0));
  }

  @Test
  void testWithNonExistingFile() {
    String file = "xxxx.json";
    Throwable exception = assertThrows(NullPointerException.class,
      () -> {
        gsonFactory.getNodesFromFile(filepathNodeDir + file);
        ;
      });
  }

  @Test
  void testFileWithInvalidNode() {
    String file = "test_invalid_node.json";
    Executable executable = () -> gsonFactory.getNodesFromFile(filepathNodeDir + file);
    assertThrows(JsonParseException.class, executable);
  }
}
