package services.resource;

import beans.BookingI;
import com.google.gson.*;
import models.Booking;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/booking")
public class BookingService {

    @EJB
    BookingI bookingI;
    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String addBooking(String json){
        Booking booking = new Gson().fromJson(json, Booking.class);
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
    public String editBooking(String json){
        Booking booking = new Gson().fromJson(json, Booking.class);
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

}
