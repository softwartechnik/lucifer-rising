package de.softwartechnik.lucifer.tree.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

public class GsonFactory {

  public List<NodeModel> getNodesFromFile(String myFilePath) {
    FileReader reader = null;
    try {
      reader = new FileReader(System.getProperty("user.dir") + myFilePath);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    var adapter = RuntimeTypeAdapterFactory.of(NodeModel.class, "type")
      .registerSubtype(MessageNodeModel.class, "message")
      .registerSubtype(QuestionNodeModel.class, "question")
      .registerSubtype(DeathNodeModel.class, "death")
      .registerSubtype(EndNodeModel.class, "end");
    var gson = new GsonBuilder().registerTypeAdapterFactory(adapter).create();
    return Arrays.asList(gson.fromJson(reader, NodeModel[].class));
  }
}
