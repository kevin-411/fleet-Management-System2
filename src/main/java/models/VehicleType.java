package models;

import javax.persistence.*;

@Entity
@Table(name = "tble_vehicle_types")
public class VehicleType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int vehicleTypeId;

    String name;
    int ratePerKm;

    public int getVehicleTypeId() {
        return vehicleTypeId;
    }

    public void setVehicleTypeId(int vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRatePerKm() {
        return ratePerKm;
    }

    public void setRatePerKm(int ratePerKm) {
        this.ratePerKm = ratePerKm;
    }
}
