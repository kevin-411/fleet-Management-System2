package services.resource;

import beans.UserI;
import com.google.gson.Gson;
import models.User;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserService {
    @EJB
    UserI userI;

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String addUser(String json){
        User user = new Gson().fromJson(json, User.class);
        userI.add(user);
        return "success";
    }

    @Path("/view/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewUserById(@PathParam("id") int id){
        User user = (User) userI.findById(id);
        return Response.ok().entity(user).build();
    }

    @Path("/edit")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String editUser(String json){
        User user = new Gson().fromJson(json, User.class);
        userI.edit(user);
        return "success";
    }

    @Path("/delete")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String deleteUser(String json){
        User user = new Gson().fromJson(json, User.class);
        userI.remove(user.getId());
        return "success";
    }
}
