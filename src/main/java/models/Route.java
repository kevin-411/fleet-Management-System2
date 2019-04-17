package models;

import javax.persistence.*;

@Entity
@Table(name = "tble_routes")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int routeId;

    String pointA;
    String pointB;
    String name;
    int lengthInKm;

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public String getPointA() {
        return pointA;
    }

    public void setPointA(String pointA) {
        this.pointA = pointA;
    }

    public String getPointB() {
        return pointB;
    }

    public void setPointB(String pointB) {
        this.pointB = pointB;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLengthInKm() {
        return lengthInKm;
    }

    public void setLengthInKm(int lengthInKm) {
        this.lengthInKm = lengthInKm;
    }
}
