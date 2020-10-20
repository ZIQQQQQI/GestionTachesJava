package Test;

import Compte.AbstractClient;
import Compte.Client;
import CompteDataBase.ClientDB;

import javax.enterprise.inject.Stereotype;
import java.sql.SQLOutput;


public class ClientDBTest {

    public void testLogin(){
        Client loginClient=new Client();
        loginClient.setMail("Samuel@yahoo.fr");
        loginClient.setMdp("982892");

        ClientDB Db =new ClientDB();
        Client client=Db.login(loginClient);

        System.out.println(client);
    }

}
