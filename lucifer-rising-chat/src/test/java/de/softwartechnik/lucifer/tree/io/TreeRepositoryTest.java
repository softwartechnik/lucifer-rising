package de.softwartechnik.lucifer.tree.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.gson.JsonParseException;
import java.nio.file.Paths;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class TreeRepositoryTest {
  private static final String TEST_RESOURCES = "src/test/resources/nodefiles/";
  private TreeRepository treeRepository;

  @BeforeEach
  void setUp() {
    treeRepository = new TreeRepository();
  }

  @Test
  void testGetQuestionNodeFromFile() {
    var path = Paths.get(TEST_RESOURCES, "test_question_node.json");
    var expectedNode = new QuestionNodeModel(
      "2",
      "How much is the fish?",
      new ChoiceModel[] {
        new ChoiceModel("RegEx", "3", 0),
        new ChoiceModel("OtherRegEx", "4", 0)
      }, 1000);
    var nodes = treeRepository.readFromFile(path);

    assertEquals(expectedNode, nodes.get(0));
  }

  @Test
  void testGetMessageNodeFromFile() {
    var path = Paths.get(TEST_RESOURCES, "test_message_node.json");
    var expectedNode = new MessageNodeModel(
      "2",
      "This much is the fish",
      "3",
      1000
    );
    var nodes = treeRepository.readFromFile(path);
    assertEquals(expectedNode, nodes.get(0));
  }

  @Test
  void testGetDeathNodeFromFile() {
    var path = Paths.get(TEST_RESOURCES, "test_death_node.json");
    var expectedNode = new DeathNodeModel("2", 1000);
    var nodes = treeRepository.readFromFile(path);
    assertEquals(expectedNode, nodes.get(0));
  }

  @Test
  void testGetEndNodeFromFile() {
    var path = Paths.get(TEST_RESOURCES, "test_end_node.json");
    var expectedNode = new EndNodeModel("2", 1000);
    var nodes = treeRepository.readFromFile(path);
    assertEquals(expectedNode, nodes.get(0));
  }

  @Test
  void testFileWithInvalidNode() {
    var path = Paths.get(TEST_RESOURCES, "test_invalid_node.json");
    Executable executable = () -> treeRepository.readFromFile(path);
    assertThrows(JsonParseException.class, executable);
  }
}
