package com.kainos.project.api;

import com.kainos.project.api.models.User;
import com.kainos.project.db.UserDB;
import io.swagger.annotations.Api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("/api")
@Api("User API")
public class UserService {
    @GET
    @Path("/users")
    @Produces({MediaType.APPLICATION_JSON})
    public List<User> getUsers() throws SQLException {
        System.out.println("tedt");
        return UserDB.getUsers();
    }

    @GET
    @Path("/users/{login}")
    @Produces({MediaType.APPLICATION_JSON})
    public User getUser(@PathParam("login") String login) throws SQLException {
        return UserDB.getUser(login);
    }
}
