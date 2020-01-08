package gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GsonFactory {

  // TODO: Take this as example, adapt for new models in Lucifer Tree
  /**
  public List<MyNode> getNodesFromFile(String myFilePath) {
    FileReader reader = null;
    try {
      reader = new FileReader(System.getProperty("user.dir")+ myFilePath);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    Type listOfMyClassObject = new TypeToken<ArrayList<MyNode>>() {}.getType();
    Gson gson = new GsonBuilder().create();
    return (reader != null) ? gson.fromJson(reader, listOfMyClassObject) : null;
  }

  public void writeNodesInFile(String myFilePath, List<MyNode> nodes) {
    try (Writer writer = new FileWriter(System.getProperty("user.dir")+ myFilePath)) {
      Gson gson = new GsonBuilder().setPrettyPrinting().create();
      gson.toJson(nodes, writer);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }  **/
}
