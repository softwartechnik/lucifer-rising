package de.softwartechnik.lucifer.session;

import de.softwartechnik.lucifer.tree.ChatSession;
import java.util.ArrayList;
import java.util.Collection;
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
    System.out.println("New Session [" + (sessions.size() + 1) + "]: " + chatSession);
    sessions.put(chatSession.id(), chatSession);
  }

  public Collection<ChatSession> findSessions() {
    System.out.println("Fetching session: " + sessions);
    return new ArrayList<>(sessions.values());
  }
}
