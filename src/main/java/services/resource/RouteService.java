package services.resource;

import beans.RouteI;
import com.google.gson.Gson;
import models.Route;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/route")
public class RouteService {
    @EJB
    RouteI routeI;

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String addRoute(String json){
        Route client = new Gson().fromJson(json, Route.class);
        routeI.add(client);
        return "success";
    }

    @Path("/view/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewRouteById(@PathParam("id") int id){
        Route route = (Route) routeI.findById(id);
        return Response.ok().entity(route).build();
    }

    @Path("/edit")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String editRoute(String json){
        Route route = new Gson().fromJson(json, Route.class);
        routeI.edit(route);
        return "success";
    }

    @Path("/delete")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String deleteRoute(String json){
        Route route = new Gson().fromJson(json, Route.class);
        routeI.remove(route.getRouteId());
        return "success";
    }
}
