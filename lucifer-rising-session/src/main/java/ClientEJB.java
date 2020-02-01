import javax.ejb.Stateful;

@Stateful
public class ClientEJB {
    private ClientState state;

    public ClientState getState() {
        return state;
    }

    public void setState(ClientState value) {
        state = value;
    }
}