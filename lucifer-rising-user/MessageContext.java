package de.softwartechnik.lucifer;

public final class MessageContext {
  private final String message;

  public MessageContext(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public void resume(Node node) {
    node.accept(this);
  }

  public void sendMessage(String response) {

  }

  public void destroy() {

  }
}
