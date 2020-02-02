package de.softwartechnik.lucifer.session;

import javax.ejb.Stateful;

@Stateful
public class ClientEjb {
  private ClientState state;

  public ClientState getState() {
    return state;
  }

  public void setState(ClientState value) {
    state = value;
  }
}