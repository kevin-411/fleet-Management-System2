package beans;

import models.Vehicle;

import javax.ejb.Stateless;

@Stateless
public class VehicleBn extends Bean implements VehicleI {

    public VehicleBn(){
        super(Vehicle.class);
    }
}
