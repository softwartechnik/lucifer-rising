package gson;

import de.softwartechnik.lucifer.tree.ChatSession;
import de.softwartechnik.lucifer.tree.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GsonFactoryTest {

  private GsonFactory gsonFactory;

  @BeforeEach
  void setUp() {
    gsonFactory = new GsonFactory();
  }

  @Test
  void testGetNodesFromFile() {
    String filepath = "/src/main/resources/nodes_apocalypse.json";
    List<Node> list =  gsonFactory.getNodesFromFile(filepath);
  }
}
