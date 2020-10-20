package Compte;

import Reclamation.Reclamation;
import Tache.AbstractMessage;

import java.text.SimpleDateFormat;
import java.util.Date;

public class messageServiceClient extends AbstractMessage {
    public ServiceClient expediteur;
    public messageServiceClient(String date, String contenu,ServiceClient expediteur) {
        super(date, contenu);
        this.expediteur=expediteur;
    }


}
