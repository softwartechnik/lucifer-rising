import javax.ejb.Stateful;

@Stateful
public class ChatEJB {
    private ChatState state;
    private String nodeId;

    public ChatState getState() {
        return state;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setState(ChatState value) {
        state = value;
    }

    public void setNodeId(String value) {
        nodeId = value;
    }
}