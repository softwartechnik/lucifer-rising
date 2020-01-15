package gson;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
      "How much is the fish?", Set.of(new Choice("RegEx", "3"), new Choice("OtherRegEx", "4")));
    List<NodeModel> result = gsonFactory.getNodesFromFile(filepathNodeDir + file);

    assertEquals(expectedNode.getClass(), result.get(0).getClass());
  }
}
