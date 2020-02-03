package de.softwartechnik.lucifer.gui.swing.client;

import de.softwartechnik.lucifer.user.User;
import org.glassfish.jersey.client.ClientConfig;

import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;

public final class UserClient {
  private static final String BASE_URL = "http://localhost:8070/lucifer-rising-game-1.0.0-SNAPSHOT";
  private final Client client;

  private UserClient(Client client) {
    this.client = client;
  }

  public User register(String username, String password) {
    return client.target(BASE_URL + "/user")
      .queryParam("userName", username)
      .queryParam("password", password)
      .request()
      .post(Entity.text(""))
      .readEntity(User.class);
  }

  public User login(String username, String password) {
    return client.target(BASE_URL + "/user/login")
      .queryParam("userName", username)
      .queryParam("password", password)
      .request()
      .post(Entity.text(""))
      .readEntity(User.class);
  }

  public static UserClient create() {
    return new UserClient(ClientBuilder.newBuilder()
    .withConfig(new ClientConfig().register(new GsonMessageBodyHandler())).build());
  }

  public static void main(String[] args) {
    UserClient userClient = UserClient.create();
    System.out.println(userClient.register("username", "password"));
    System.out.println(userClient.login("username", "password"));
  }
}
