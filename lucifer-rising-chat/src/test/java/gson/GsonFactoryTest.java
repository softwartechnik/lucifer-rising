package gson;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class GsonFactoryTest {

  private GsonFactory gsonFactory;
  private final String filepath = "/src/main/resources/test.json";

  @BeforeEach
  void setUp() {
    gsonFactory = new GsonFactory();
  }

  @Test
  void testGetQuestionNodeFromFile() {
    List<NodeModel> result =  gsonFactory.getNodesFromFile(filepath);

    assertEquals(result.get(0).getClass(), QuestionNodeModel.class);
  }
}
