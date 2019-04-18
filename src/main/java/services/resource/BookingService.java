package services.resource;

import beans.*;
import com.google.gson.*;
import models.*;

import javax.ejb.EJB;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/booking")
public class BookingService {

    @EJB
    BookingI bookingI;
    @EJB
    RouteI routeI;
    @EJB
    VehicleI vehicleI;
    @EJB
    UserI userI;
    @EJB
    StaffI staffI;

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public String addBooking(String json){
        Booking booking = createBooking(json);
        bookingI.add(booking);
        return "success";
    }

    @Path("/view/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewBookingById(@PathParam("id") int id){
        Booking booking = (Booking) bookingI.findById(id);
        return Response.ok().entity(booking).build();
    }

    @Path("/edit")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public String editBooking(String json){
        Booking booking = createBooking(json);
        bookingI.edit(booking);
        return "success";
    }

    @Path("/delete")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String deleteBooking(String json){
        Booking booking = new Gson().fromJson(json, Booking.class);
        bookingI.remove(booking.getId());
        return "success";
    }

    public Booking createBooking(String json){
        Booking booking = new Booking();
        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        try{
            int id = jsonObject.get("id").getAsInt();
            booking.setId(id);
        } catch (NullPointerException e){
            System.out.print("adding");
        }
        int userId = jsonObject.get("userId").getAsInt();
        int vehicleId = jsonObject.get("vehicleId").getAsInt();
        int routeId = jsonObject.get("routeId").getAsInt();
        int staffId = jsonObject.get("staffId").getAsInt();
        Route route = (Route)routeI.findById(routeId);
        Vehicle vehicle = (Vehicle)vehicleI.findById(vehicleId);
        int distance = route.getLengthInKm();
        int ratePerKm = vehicle.getTypeId().getRatePerKm();
        int cost = distance * ratePerKm;
        booking.setCost(cost);
        booking.setClientId((User)userI.findById(userId));
        booking.setRouteId(route);
        booking.setVehicleId(vehicle);
        booking.setStaffId((Staff)staffI.findById(staffId));
        return booking;
    }

}
