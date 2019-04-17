package services.resource;

import beans.StaffI;
import com.google.gson.Gson;
import models.Staff;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/staff")
public class StaffService {
    @EJB
    StaffI staffI;

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String addStaff(String json){
        Staff staff = new Gson().fromJson(json, Staff.class);
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
    public String editStaff(String json){
        Staff staff = new Gson().fromJson(json, Staff.class);
        staffI.edit(staff);
        return "success";
    }

    @Path("/delete")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String deleteStaff(String json){
        Staff staff = new Gson().fromJson(json, Staff.class);
        staffI.remove(staff.getId());
        return "success";
    }
}
