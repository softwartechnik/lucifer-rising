import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class User {

  @Id
  @GeneratedValue
  private int id;
  private String name;
  private int gamesPlayed;
  private int gamesWon;

  User(int id, String name, int gamesPlayed, int gamesWon) {
    this.id = id;
    this.name = name;
    this.gamesPlayed = gamesPlayed;
    this.gamesWon = gamesWon;
  }

  public User() { }
}
