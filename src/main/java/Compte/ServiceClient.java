package Compte;

import Donnee.AbstractServiceClient;
import Reclamation.Reclamation;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ServiceClient extends AbstractServiceClient {
    public ServiceClient(String nomServiceClient) {
        super(nomServiceClient);
    }





    public void envoyerMessageReclamation(String contenu, Reclamation reclamation){
        SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
        String date = sdf.format(new Date());

        reclamation.addMessage(new messageServiceClient(date,contenu,this));
    }
}
