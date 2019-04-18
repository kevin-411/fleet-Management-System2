package models;

import javax.persistence.*;

@Entity
@Table(name="tble_bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    int cost;
    @OneToOne(cascade = CascadeType.ALL)
    User userId;
    @OneToOne(cascade = CascadeType.ALL)
    Vehicle vehicleId;
    @OneToOne(cascade = CascadeType.ALL)
    Route routeId;
    @OneToOne(cascade = CascadeType.ALL)
    Staff staffId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public User getClientId() {
        return userId;
    }

    public void setClientId(User userId) {
        this.userId = userId;
    }

    public Vehicle getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Vehicle vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Route getRouteId() {
        return routeId;
    }

    public void setRouteId(Route routeId) {
        this.routeId = routeId;
    }

    public Staff getStaffId() {
        return staffId;
    }

    public void setStaffId(Staff staffId) {
        this.staffId = staffId;
    }
}
