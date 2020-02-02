package de.softwartechnik.lucifer.tree;

import de.softwartechnik.lucifer.tree.node.Node;

public final class MessageContext {
  private final ChatSession chatSession;
  private final String message;

  public MessageContext(ChatSession chatSession, String message) {
    this.chatSession = chatSession;
    this.message = message;
  }

  public String message() {
    return message;
  }

  public void respond(String message) {
    chatSession.sendMessage(message);
  }

  public void resume(Node node) {
    chatSession.setCurrentNode(node);
    node.accept(this);
  }

  public void killSession() {
    chatSession.kill();
  }

  public void winGame() {
    chatSession.end();
  }
}
