package de.softwartechnik.lucifer.gui.swing.client;

import com.google.gson.JsonObject;
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

  public JsonObject createGame(String userId, String scenario) {
    return client.target(BASE_URL + "/game")
      .queryParam("userId", userId)
      .queryParam("scenario", scenario)
      .request()
      .post(Entity.text(""))
      .readEntity(JsonObject.class);
  }

  public static GameClient create() {
    return new GameClient(ClientBuilder.newBuilder()
    .withConfig(new ClientConfig().register(new GsonMessageBodyHandler())).build());
  }

  public static void main(String[] args) {
    GameClient gameClient = GameClient.create();
    System.out.println(gameClient.createGame("1", "apocalypse"));
  }
}
