package de.softwartechnik.lucifer.session;

import de.softwartechnik.lucifer.tree.Tree.Walker;
import de.softwartechnik.lucifer.user.User;
import javax.ejb.Stateful;

@Stateful
public class ChatSession {
  private final User user;
  private final Walker walker;

  public ChatSession(User user, Walker walker) {
    this.user = user;
    this.walker = walker;
  }


}
