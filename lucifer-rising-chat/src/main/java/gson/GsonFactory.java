package gson;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import de.softwartechnik.lucifer.tree.MessageContext;
import de.softwartechnik.lucifer.tree.Node;
import de.softwartechnik.lucifer.tree.QuestionNode;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Predicate;

public class GsonFactory {


  public List<Node> getNodesFromFile(String myFilePath) {

    List<Node> nodes = new ArrayList<>();
    FileReader reader = null;
    try {
      reader = new FileReader(System.getProperty("user.dir")+ myFilePath);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    GsonBuilder gsonBuilder = new GsonBuilder();
    gsonBuilder.registerTypeAdapter(Node.class, new NodeAdapter());

    Type listOfMyClassObject = new TypeToken<ArrayList<Node>>() {}.getType();
    Gson gson = gsonBuilder.create();

    return gson.fromJson(reader, listOfMyClassObject);
  }

  private final class NodeAdapter implements JsonSerializer<Node>, JsonDeserializer<Node> {
    @Override
    public JsonElement serialize(Node src, Type typeOfSrc, JsonSerializationContext context) {
      JsonObject result = new JsonObject();
      result.add("type", new JsonPrimitive(src.getClass().getSimpleName()));
      result.add("properties", context.serialize(src, src.getClass()));
      return result;
    }

    @Override
    public Node deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException {
      JsonObject jsonObject = json.getAsJsonObject();
      String type = jsonObject.get("type").getAsString();
      JsonElement element = jsonObject.get("properties");

      try {
        switch (type) {
          case("death") : return context.deserialize(element, Class.forName("de.softwartechnik.lucifer.tree.DeathNode"));
          case("question") : return context.deserialize(element, ModelMapperQuestionNode.class);
          case("message") : return context.deserialize(element, ModelMapperMessageNode.class);
          default: throw new Exception("Unknown element type");
        }

      } catch (Exception e) {
        throw new JsonParseException(e);
      }
    }
  }

  private final class ModelMapperQuestionNode implements Node{
    private final String question;
    private final Set<QuestionNode.Choice> choices;

    private ModelMapperQuestionNode(
      String question,
      Set<QuestionNode.Choice> choices
    ) {
      this.question = question;
      this.choices = choices;
    }

    @Override
    public void accept(MessageContext messageContext) {

    }
  }

  private final class ModelMapperMessageNode implements Node {
    private final String message;
    private final String nextNode;

    private ModelMapperMessageNode(String message, String nextNode) {
      this.message = message;
      this.nextNode = nextNode;
    }

    @Override
    public void accept(MessageContext messageContext) {

    }
  }

  public static final class Choice {
    private final String matcher;
    private final String nextNode;

    public Choice(String matcher, String nextNode) {
      this.matcher = matcher;
      this.nextNode = nextNode;
    }
  }
}
