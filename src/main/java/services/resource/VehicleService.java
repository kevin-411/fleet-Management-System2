package services.resource;

import beans.RouteI;
import beans.VehicleI;
import beans.VehicleTypeI;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import models.Route;
import models.Vehicle;
import models.VehicleType;

import javax.ejb.EJB;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/vehicle")
public class VehicleService {
    @EJB
    VehicleI vehicleI;
    @EJB
    VehicleTypeI vehicleTypeI;
    @EJB
    RouteI routeI;

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public String addVehicle(String json){
        //Vehicle vehicle = new Gson().fromJson(json, Vehicle.class);
        Vehicle vehicle = new Vehicle();
        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        int routeId = jsonObject.get("routeId").getAsInt();
        int typeId = jsonObject.get("typeId").getAsInt();
        boolean isActive = jsonObject.get("isActive").getAsBoolean();
        String name = jsonObject.get("vehicleName").getAsString();
        vehicle.setRouteId((Route) routeI.findById(routeId));
        vehicle.setActive(isActive);
        vehicle.setVehicleName(name);
        vehicle.setTypeId((VehicleType)vehicleTypeI.findById(typeId));
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
    @Transactional
    public String editVehicle(String json){
        Vehicle vehicle = new Vehicle();
        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        int routeId = jsonObject.get("routeId").getAsInt();
        int typeId = jsonObject.get("typeId").getAsInt();
        int vehicleId = jsonObject.get("vehicleId").getAsInt();
        boolean isActive = jsonObject.get("isActive").getAsBoolean();
        String name = jsonObject.get("vehicleName").getAsString();
        vehicle.setVehicleId(vehicleId);
        vehicle.setRouteId((Route) routeI.findById(routeId));
        vehicle.setActive(isActive);
        vehicle.setVehicleName(name);
        vehicle.setTypeId((VehicleType)vehicleTypeI.findById(typeId));
        vehicleI.edit(vehicle);
        return "success";
    }

    @Path("/delete")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public String deleteVehicle(String json){
        //Vehicle vehicle = new Ve;
        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        int vehicleId = jsonObject.get("vehicleId").getAsInt();
        vehicleI.remove(vehicleId);
        return "success";
    }
}
