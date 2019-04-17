package models;

import javax.persistence.*;

@Entity
@Table(name = "tble_vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int vehicleId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    VehicleType typeId;

    String vehicleName;

    @ManyToOne(cascade = CascadeType.ALL)
    Route routeId;

    boolean isActive;

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public VehicleType getTypeId() {
        return typeId;
    }

    public void setTypeId(VehicleType typeId) {
        this.typeId = typeId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public Route getRouteId() {
        return routeId;
    }

    public void setRouteId(Route routeId) {
        this.routeId = routeId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
