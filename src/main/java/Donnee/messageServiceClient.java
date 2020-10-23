package Donnee;

import Donnee.ServiceClient;
import Tache.AbstractMessage;

public class messageServiceClient extends AbstractMessage {

    // Nous avons décidé de ne pas traiter ce scénario car il est similaire à Message intervenant.
    // La seule différence réside dans le type d'expediteur
    public ServiceClient expediteur;
    public messageServiceClient(String date, String contenu,ServiceClient expediteur) {
        super(date, contenu);
        this.expediteur=expediteur;
    }


}
