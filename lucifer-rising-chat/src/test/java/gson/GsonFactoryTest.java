package gson;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


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
      "How much is the fish?", new Choice[]{new Choice("RegEx", "3"), new Choice("OtherRegEx", "4")});
    List<NodeModel> result = gsonFactory.getNodesFromFile(filepathNodeDir + file);

    assertEquals(expectedNode, result.get(0));
  }

  @Test
  void testGetMessageNodeFromFile() {
    String file = "test_message_node.json";
    MessageNodeModel expectedNode = new MessageNodeModel("2", "This much is the fish", "3");
    List<NodeModel> result = gsonFactory.getNodesFromFile(filepathNodeDir + file);

    assertEquals(expectedNode, result.get(0));
  }

  @Test
  void testGetDeathNodeFromFile() {
    String file = "test_death_node.json";
    DeathNodeModel expectedNode = new DeathNodeModel("2");
    List<NodeModel> result = gsonFactory.getNodesFromFile(filepathNodeDir + file);

    assertEquals(expectedNode, result.get(0));
  }

  @Test
  void testGetEndNodeFromFile() {
    String file = "test_end_node.json";
    EndNodeModel expectedNode = new EndNodeModel("2");
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
}
