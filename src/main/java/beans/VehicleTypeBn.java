package beans;

import models.VehicleType;

import javax.ejb.Stateless;

@Stateless
public class VehicleTypeBn extends Bean implements VehicleTypeI {

    public VehicleTypeBn(){
        super(VehicleType.class);
    }
}
