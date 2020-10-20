package Donnee;

import Donnee.ServiceClient;
import Tache.AbstractMessage;

public class messageServiceClient extends AbstractMessage {
    public ServiceClient expediteur;
    public messageServiceClient(String date, String contenu,ServiceClient expediteur) {
        super(date, contenu);
        this.expediteur=expediteur;
    }


}
