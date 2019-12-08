package gson;
import model.MyNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class gsonFactoryTest {
  String filePath;
  GsonFactory gson;
  @Before
  public void setUp() throws Exception {
      filePath = "/src/main/resources/test.json";
      gson = new GsonFactory();
  }

  @Test
  public void getNodesFromFile(){
    List<MyNode> expectedList = new ArrayList<MyNode>();
    expectedList.add(new MyNode(1,"I am the first node", "theType", new int[] {2,3}, new HashMap<>()));
    expectedList.add(new MyNode(2,"I am the second node", "theOtherType", new int[] {4,5}, new HashMap<>()));

    gson.writeNodesInFile(filePath, expectedList);

    Assert.assertEquals(expectedList, gson.getNodesFromFile(filePath));
  }

  @Test
  public void writeNodesInFile()  {
    List<MyNode> list = new ArrayList<MyNode>();
    list.add(new MyNode(1,"I am the first node", "theType", new int[] {2,3}, new HashMap<>()));
    list.add(new MyNode(2,"I am the second node", "theOtherType", new int[] {4,5}, new HashMap<>()));

    gson.writeNodesInFile(filePath, list);

    Assert.assertEquals(list, gson.getNodesFromFile(filePath));
  }

  @Test
  public void getNodesFromNotExisitingFile() {
    Assert.assertNull(gson.getNodesFromFile("/"));
  }
}
