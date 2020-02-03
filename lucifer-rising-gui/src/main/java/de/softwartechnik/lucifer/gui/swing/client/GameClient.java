package de.softwartechnik.lucifer.gui.swing.client;

import com.google.gson.JsonObject;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import org.glassfish.jersey.client.ClientConfig;

public final class GameClient {
  private static final String BASE_URL = "http://localhost:8070/lucifer-rising-game-1.0.0-SNAPSHOT";
  private final Client client;

  private GameClient(Client client) {
    this.client = client;
  }

  public String createGame(String userId, String scenario) {
    return client.target(BASE_URL + "/game")
      .queryParam("userId", userId)
      .queryParam("scenario", scenario)
      .request()
      .post(Entity.text(""))
      .readEntity(String.class);
  }

  public Answer sendMessage(String sessionId, String message) {
    Answer entity = client.target(BASE_URL + "/game/message")
      .queryParam("sessionId", sessionId)
      .request()
      .post(Entity.text(message))
      .readEntity(Answer.class);

    return entity;
  }

  public static GameClient create() {
    return new GameClient(ClientBuilder.newBuilder()
    .withConfig(new ClientConfig().register(new GsonMessageBodyHandler())).build());
  }

  public static void main(String[] args) {
    GameClient gameClient = GameClient.create();
    System.out.println(gameClient.createGame("1", "apocalypse"));
  }

  public static final class Answer {
    private List<String> messages;

    public Answer(List<String> messages) {
      this.messages = messages;
    }

    public List<String> messages() {
      return messages;
    }

    public void setMessages(List<String> messages) {
      this.messages = messages;
    }

    @Override
    public String toString() {
      final StringBuilder sb = new StringBuilder("Answer{");
      sb.append("messages=").append(messages);
      sb.append('}');
      return sb.toString();
    }
  }
}
