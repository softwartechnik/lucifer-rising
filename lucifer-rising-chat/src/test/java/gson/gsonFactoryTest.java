package gson;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import model.MyNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class gsonFactoryTest {
  String filePath;
  GsonFactory gson;
  @Before
  public void setUp() throws Exception {
      filePath = "/src/main/resources/nodes.json";
      gson = new GsonFactory();
  }

  @Test
  public void getNodesFromFile() throws FileNotFoundException {
    List<MyNode> expectedList = new ArrayList<MyNode>();
    expectedList.add(new MyNode(1,"I am the first node", "theType", new int[] {2,3}, new HashMap<>()));
    expectedList.add(new MyNode(2,"I am the second node", "theOtherType", new int[] {4,5}, new HashMap<>()));
    // TODO check complete list at once (equals(Object o), hasItems,...)
    Assert.assertEquals(expectedList.get(0), gson.getNodesFromFile(filePath).get(0));
  }

}
