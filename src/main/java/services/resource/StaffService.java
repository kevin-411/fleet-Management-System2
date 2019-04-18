package services.resource;

import beans.StaffI;
import beans.UserI;
import beans.VehicleTypeI;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import models.Staff;
import models.User;
import models.VehicleType;

import javax.ejb.EJB;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/staff")
public class StaffService {
    @EJB
    StaffI staffI;
    @EJB
    VehicleTypeI vehicleTypeI;
    @EJB
    UserI userI;

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public String addStaff(String json){
        Staff staff = createStaff(json);
        staffI.add(staff);
        return "success";
    }

    @Path("/view/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewStaffById(@PathParam("id") int id){
        Staff staff = (Staff) staffI.findById(id);
        return Response.ok().entity(staff).build();
    }

    @Path("/edit")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public String editStaff(String json){
        Staff staff = createStaff(json);
        staffI.edit(staff);
        return "success";
    }

    @Path("/delete")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String deleteStaff(String json){
        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        int staffId = jsonObject.get("id").getAsInt();
        staffI.remove(staffId);
        return "success";
    }

    public Staff createStaff(String json){
        Staff staff = new Staff();
        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        try{
            int id = jsonObject.get("id").getAsInt();
            staff.setId(id);
        } catch (NullPointerException e){
            ;
        }
        int userId = jsonObject.get("userId").getAsInt();
        int vehicleTypeId = jsonObject.get("vehicleTypeId").getAsInt();
        boolean isActive = jsonObject.get("isActive").getAsBoolean();
        staff.setActive(isActive);
        staff.setUserId((User) userI.findById(userId));
        staff.setVehicleTypeId((VehicleType) vehicleTypeI.findById(vehicleTypeId));
        return staff;
    }
}
