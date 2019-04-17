package beans;

import models.Client;

import javax.ejb.Stateless;

@Stateless
public class ClientBn extends Bean implements ClientI {

    public ClientBn(){
        super(Client.class);
    }

}
