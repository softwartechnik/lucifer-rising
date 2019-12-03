import javax.ejb.Stateful;

@Stateful
public class GameEJB {
    public GameState state;
    public int nodeId;

    public GameState getState() {
        return state;
    }

    public int getNodeId() {
        return nodeId;
    }

    public void setState(GameState value) {
        state = value;
    }

    public void setNodeId(int value) {
        nodeId = value;
    }
}