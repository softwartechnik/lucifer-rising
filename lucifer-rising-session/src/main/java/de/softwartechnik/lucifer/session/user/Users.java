package de.softwartechnik.lucifer.session.user;

import de.softwartechnik.lucifer.user.User;
import de.softwartechnik.lucifer.user.UserService;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/user")
public class Users {
  @Inject
  private UserService userService;

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
