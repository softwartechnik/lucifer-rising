package gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.MyNode;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GsonFactory {

  public List<MyNode> getNodesFromFile(String myFilePath) throws FileNotFoundException {
    FileReader reader = null;
    try {
      reader = new FileReader(System.getProperty("user.dir")+ myFilePath);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    Type listOfMyClassObject = new TypeToken<ArrayList<MyNode>>() {}.getType();
    Gson gson = new Gson();
    return gson.fromJson(reader, listOfMyClassObject);
  }
}
