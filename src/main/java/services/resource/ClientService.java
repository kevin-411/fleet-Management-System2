package services.resource;

import beans.ClientI;
import com.google.gson.Gson;
import models.Client;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/client")
public class ClientService {
    @EJB
    ClientI clientI;

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String addClient(String json){
        Client client = new Gson().fromJson(json, Client.class);
        clientI.add(client);
        return "success";
    }

    @Path("/view/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewClientById(@PathParam("id") int id){
        Client client = (Client) clientI.findById(id);
        return Response.ok().entity(client).build();
    }

    @Path("/edit")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String editClient(String json){
        Client client = new Gson().fromJson(json, Client.class);
        clientI.edit(client);
        return "success";
    }

    @Path("/delete")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String deleteClient(String json){
        Client client = new Gson().fromJson(json, Client.class);
        clientI.remove(client.getId());
        return "success";
    }
}
