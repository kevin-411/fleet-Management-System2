package services.resource;

import beans.VehicleI;
import com.google.gson.Gson;
import models.Vehicle;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/vehicle")
public class VehicleService {
    @EJB
    VehicleI vehicleI;

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String addVehicle(String json){
        Vehicle vehicle = new Gson().fromJson(json, Vehicle.class);
        vehicleI.add(vehicle);
        return "success";
    }

    @Path("/view/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewVehicleById(@PathParam("id") int id){
        Vehicle vehicle = (Vehicle) vehicleI.findById(id);
        return Response.ok().entity(vehicle).build();
    }

    @Path("/edit")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String editVehicle(String json){
        Vehicle vehicle = new Gson().fromJson(json, Vehicle.class);
        vehicleI.edit(vehicle);
        return "success";
    }

    @Path("/delete")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String deleteVehicle(String json){
        Vehicle vehicle = new Gson().fromJson(json, Vehicle.class);
        vehicleI.remove(vehicle.getVehicleId());
        return "success";
    }
}
