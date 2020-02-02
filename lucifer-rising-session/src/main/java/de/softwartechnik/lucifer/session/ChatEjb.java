package de.softwartechnik.lucifer.session;

import javax.ejb.Stateful;

@Stateful
public class ChatEjb {
  private ChatState state;
  private String nodeId;

  public ChatState getState() {
    return state;
  }

  public void setState(ChatState value) {
    state = value;
  }

  public String getNodeId() {
    return nodeId;
  }

  public void setNodeId(String value) {
    nodeId = value;
  }
}