package de.softwartechnik.lucifer.tree.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapterFactory;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public final class TreeRepository {
  public List<NodeModel> readFromFile(Path path) {
    Objects.requireNonNull(path);
    var nodeModels = tryReadNodes(path);
    return Arrays.asList(nodeModels);
  }

  private NodeModel[] tryReadNodes(Path path) {
    var gson = createGson();
    try (var reader = Files.newBufferedReader(path)){
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
}
