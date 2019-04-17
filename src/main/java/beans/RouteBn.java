package beans;

import models.Route;

import javax.ejb.Stateless;

@Stateless
public class RouteBn extends Bean implements RouteI {

    public RouteBn(){
        super(Route.class);
    }

}
