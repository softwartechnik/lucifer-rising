package de.softwartechnik.lucifer.session;

import de.softwartechnik.lucifer.tree.ChatSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import javax.ejb.Singleton;

@Singleton
public class SessionRegistry {
  private final Map<String, ChatSession> sessions = new HashMap<>();

  public Optional<ChatSession> findSession(String sessionId) {
    return Optional.ofNullable(sessions.get(sessionId));
  }

  public void addSession(ChatSession chatSession) {
    sessions.remove(chatSession.id());
  }
}
