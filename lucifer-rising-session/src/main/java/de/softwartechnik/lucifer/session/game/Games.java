package de.softwartechnik.lucifer.session.game;

import de.softwartechnik.lucifer.session.SessionRegistry;
import de.softwartechnik.lucifer.tree.ChatSession;
import de.softwartechnik.lucifer.tree.io.TreeRepository;
import de.softwartechnik.lucifer.tree.node.Tree;
import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@ApplicationScoped
@Path("/game")
public class Games {
  @Inject
  private SessionRegistry sessionRegistry;
  private TreeRepository treeRepository = new TreeRepository();

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Collection<ChatSession> findGames() {
    return sessionRegistry.findSessions();
  }

  @GET
  @Path("/{sessionId}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response findGame(
    @PathParam("sessionId") String sessionId
  ) {
    Optional<ChatSession> session = sessionRegistry.findSession(sessionId);
    if (session.isEmpty()) {
      return Response.status(Status.NOT_FOUND).build();
    }
    return Response.ok(session.get()).build();
  }

  private static final String INITIAL_MESSAGE = "";

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/{sessionId}/message")
  public Response fetchMessageBuffer(
    @PathParam("sessionId") String sessionId
  ) {
    Optional<ChatSession> session = sessionRegistry.findSession(sessionId);
    if (session.isEmpty()) {
      return Response.status(Status.NOT_FOUND).build();
    }
    List<String> responses = session.get().responses();
    return Response.ok(new Answer(responses)).build();
  }

  @POST
  @Consumes(MediaType.TEXT_PLAIN)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/{sessionId}/message")
  public Response onMessage(
    @PathParam("sessionId") String sessionId,
    String message
  ) {
    System.out.println("Handling message " + message + " for session " + sessionId);
    Optional<ChatSession> session = sessionRegistry.findSession(sessionId);
    if (session.isEmpty()) {
      return Response.status(Status.NOT_FOUND).build();
    }
    ChatSession chatSession = session.get();
    chatSession.onMessage(message);
    List<String> responses = chatSession.responses();
    System.out.println(responses);
    return Response.ok(new Answer(responses)).build();
  }

  public static final class Answer {
    private final List<String> messages;

    public Answer(List<String> messages) {
      this.messages = messages;
    }

    public List<String> messages() {
      return messages;
    }
  }

  @POST
  public Response createGame(
    @QueryParam("userId") String userId,
    @QueryParam("scenario") String scenario
  ) {
    Optional<Tree> tree = treeRepository.findTree(scenario);
    if (tree.isEmpty()) {
      return Response.status(Status.NOT_FOUND).build();
    }
    Game game = new Game(UUID.randomUUID().toString());
    sessionRegistry.addSession(game);
    game.begin(tree.get().rootNode(), INITIAL_MESSAGE);
    return Response
      .created(URI.create("/game/" + game.id()))
      .entity(game.id())
      .build();
  }
}
