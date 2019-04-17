package beans;

import models.User;

import javax.ejb.Stateless;

@Stateless
public class UserBn extends Bean implements UserI {

    public UserBn(){
        super(User.class);
    }

}
