package de.softwartechnik.lucifer.tree;

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
    System.out.println(message);
  }

  public void follow(Node node) {
    node.accept(this);
  }

  public void resume(Node node) {
    chatSession.setCurrentNode(node);
  }

  public void killSession() {
    System.out.println("KILLED!");
  }
}
