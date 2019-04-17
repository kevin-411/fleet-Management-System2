package beans;

import models.Booking;

import javax.ejb.Stateless;

@Stateless
public class BookingBn extends Bean implements BookingI {

    public BookingBn() {
        super(Booking.class);
    }

}
