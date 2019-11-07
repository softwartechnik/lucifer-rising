import java.util.UUID;

public class User {
  private final UUID id;
  private final String name;

  private User(UUID id, String name) {
    this.id = id;
    this.name = name;
  }


  public String getName() {
    return name;
  }

  public UUID getId() {
    return id;
  }
}
