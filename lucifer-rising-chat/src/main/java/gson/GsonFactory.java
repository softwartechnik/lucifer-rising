package gson;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import de.softwartechnik.lucifer.tree.*;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class GsonFactory {

  public List<Node> getNodesFromFile(String myFilePath) {

    FileReader reader = null;
    try {
      reader = new FileReader(System.getProperty("user.dir") + myFilePath);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    RuntimeTypeAdapterFactory<Node> adapter = RuntimeTypeAdapterFactory.of(Node.class, "type")
      .registerSubtype(MessageNode.class, "message")
      .registerSubtype(QuestionNode.class, "question")
      .registerSubtype(DeathNode.class, "death");

    Gson gson = new GsonBuilder().registerTypeAdapterFactory(adapter).create();
    Node[] nodes = gson.fromJson(reader, Node[].class);

    return Arrays.asList(nodes);
  }
}
