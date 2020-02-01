package de.softwartechnik.lucifer.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
final class User {

  @Id
  @GeneratedValue
  private int id;
  private String name;
  private String password;
  private int gamesPlayed;
  private int gamesWon;

  User(String name, String password) {
    this.name = name;
    this.password = password;
  }

  public User() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public int getGamesPlayed() {
    return gamesPlayed;
  }

  public void setGamesPlayed(int gamesPlayed) {
    this.gamesPlayed = gamesPlayed;
  }

  public int getGamesWon() {
    return gamesWon;
  }

  public void setGamesWon(int gamesWon) {
    this.gamesWon = gamesWon;
  }
}
