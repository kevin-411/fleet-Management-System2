package services.resource;

import beans.VehicleTypeI;
import com.google.gson.Gson;
import models.VehicleType;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/vehicleType")
public class VehicleTypeService {
    @EJB
    VehicleTypeI vehicleTypeI;

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String addVehicleType(String json){
        VehicleType vehicleType = new Gson().fromJson(json, VehicleType.class);
        vehicleTypeI.add(vehicleType);
        return "success";
    }

    @Path("/view/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewVehicleTypeById(@PathParam("id") int id){
        VehicleType vehicleType = (VehicleType) vehicleTypeI.findById(id);
        return Response.ok().entity(vehicleType).build();
    }

    @Path("/edit")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String editVehicleType(String json){
        VehicleType vehicleType = new Gson().fromJson(json, VehicleType.class);
        vehicleTypeI.edit(vehicleType);
        return "success";
    }

    @Path("/delete")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String deleteVehicleType(String json){
        VehicleType vehicleType = new Gson().fromJson(json, VehicleType.class);
        vehicleTypeI.remove(vehicleType.getVehicleTypeId());
        return "success";
    }
}
