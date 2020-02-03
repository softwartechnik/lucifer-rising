package de.softwartechnik.lucifer.session.user;

import de.softwartechnik.lucifer.user.User;
import de.softwartechnik.lucifer.user.UserService;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/user")
public class Users {
  @Inject
  private UserService userService;

  @GET
  public Response find(
    @QueryParam("userId") int userId
  ) {
    User user = userService.read(userId);
    if (user == null) {
      return Response.status(Status.NOT_FOUND).build();
    }
    return Response.ok(user).build();
  }


  @POST
  public Response register(
    @QueryParam("userName") String userName,
    @QueryParam("password") String password
  ) {
    User user = userService.registrate(userName, password);
    return Response.ok(user).build();
  }

  @POST
  @Path("/login")
  public Response login(
    @QueryParam("userName") String userName,
    @QueryParam("password") String password
  ) {
    User user = userService.signIn(userName, password);
    return Response.ok(user).build();
  }
}
