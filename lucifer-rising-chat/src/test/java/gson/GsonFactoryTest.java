package gson;

import de.softwartechnik.lucifer.tree.QuestionNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.crypto.spec.ChaCha20ParameterSpec;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;


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
}
