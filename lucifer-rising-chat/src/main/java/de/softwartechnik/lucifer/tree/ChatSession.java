package de.softwartechnik.lucifer.tree;

import de.softwartechnik.lucifer.tree.node.Node;
import java.util.List;

public interface ChatSession {
  void sendMessage(String message);

  void setCurrentNode(Node node);

  void end();

  void kill();

  void onMessage(String messageText);

  String id();

  List<String> responses();
}
