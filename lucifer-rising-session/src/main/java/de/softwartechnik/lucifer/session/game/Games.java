package de.softwartechnik.lucifer.session.game;

import de.softwartechnik.lucifer.session.SessionRegistry;
import de.softwartechnik.lucifer.tree.ChatSession;
import de.softwartechnik.lucifer.tree.io.TreeRepository;
import de.softwartechnik.lucifer.tree.node.Tree;
import java.net.URI;
import java.util.Optional;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/game")
public class Games {
  @Inject
  private SessionRegistry sessionRegistry;
  private TreeRepository treeRepository = new TreeRepository();

  @GET
  public Response findGame(
    @QueryParam("sessionId") String sessionId
  ) {
    Optional<ChatSession> session = sessionRegistry.findSession(sessionId);
    if (session.isEmpty()) {
      return Response.status(Status.NOT_FOUND).build();
    }
    return Response.ok(session.get()).build();
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
    ChatSession chatSession = ChatSession.of(tree.orElseThrow());
    sessionRegistry.addSession(chatSession);
    return Response.created(URI.create("/game/" + chatSession.id())).build();
  }
}
