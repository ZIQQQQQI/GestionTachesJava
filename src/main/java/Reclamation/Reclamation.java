package Reclamation;

import Compte.AbstractClient;
import Compte.AbstractIntervenant;
import Donnee.AbstractServiceClient;
import Tache.AbstractMessage;
import Tache.AbstractTache;

public class Reclamation extends  AbstractReclamation{
    public Reclamation( AbstractTache tache) {
        super(tache);
    }

    //add un message dans list de message
    public void addMessage(AbstractMessage message){
        super.listMessage.add(message);
    }





    //set et get des attribut dans abstractReclamation
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public AbstractClient getClient() {
        return client;
    }

    public void setClient(AbstractClient client) {
        this.client = client;
    }

    public AbstractIntervenant getIntervenant() {
        return intervenant;
    }

    public void setIntervenant(AbstractIntervenant intervenant) {
        this.intervenant = intervenant;
    }

    public AbstractServiceClient getServiceClient() {
        return serviceClient;
    }

    public void setServiceClient(AbstractServiceClient serviceClient) {
        this.serviceClient = serviceClient;
    }
}
