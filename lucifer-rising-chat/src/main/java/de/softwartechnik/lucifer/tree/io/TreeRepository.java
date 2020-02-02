package de.softwartechnik.lucifer.tree.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapterFactory;
import de.softwartechnik.lucifer.tree.node.Tree;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.enterprise.inject.Default;
import javax.inject.Singleton;

@Singleton
@Default
public class TreeRepository {
  public List<NodeModel> readFromFile(Path path) {
    Objects.requireNonNull(path);
    var nodeModels = tryReadNodes(path);
    return Arrays.asList(nodeModels);
  }

  private NodeModel[] tryReadNodes(Path path) {
    try (var reader = Files.newBufferedReader(path)) {
      var gson = createGson();
      return gson.fromJson(reader, NodeModel[].class);
    } catch (IOException e) {
      e.printStackTrace();
      return new NodeModel[0];
    }
  }

  private Gson createGson() {
    var typeAdapterFactory = nodeFactory();
    return new GsonBuilder()
      .registerTypeAdapterFactory(typeAdapterFactory)
      .setPrettyPrinting()
      .setLenient()
      .create();
  }

  private TypeAdapterFactory nodeFactory() {
    return RuntimeTypeAdapterFactory.of(NodeModel.class, "type")
      .registerSubtype(MessageNodeModel.class, "message")
      .registerSubtype(QuestionNodeModel.class, "question")
      .registerSubtype(DeathNodeModel.class, "death")
      .registerSubtype(EndNodeModel.class, "end");
  }

  public Optional<Tree> findTree(String scenario) {
    try (
      var inputStream = getClass().getResourceAsStream(scenario + ".json");
      var reader = new InputStreamReader(inputStream)
      ) {
      return Optional.of(tryReadNodes(scenario, reader));
    } catch (IOException e) {
      e.printStackTrace();
      return Optional.empty();
    }
  }

  private Tree tryReadNodes(String treeName, InputStreamReader reader) {
    var gson = createGson();
    return Tree.of(treeName, Arrays.asList(gson.fromJson(reader, NodeModel[].class)));
  }
}
