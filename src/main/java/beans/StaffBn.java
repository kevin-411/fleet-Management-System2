package beans;

import models.Staff;

import javax.ejb.Stateless;

@Stateless
public class StaffBn extends Bean implements StaffI {

    public StaffBn(){
        super(Staff.class);
    }
}
